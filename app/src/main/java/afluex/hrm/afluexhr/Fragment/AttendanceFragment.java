package afluex.hrm.afluexhr.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Model.CommponPuchInPuchOutResponse;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.Utils;
import afluex.hrm.afluexhr.databinding.FragmentAttendanceBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AttendanceFragment extends Fragment {
    FragmentAttendanceBinding binding;

    String lastActivity="",lastActivityDate="";
    String currentDate=null;
    SharedPreferences.Editor editor;
    private static final int Location_Request_code = 100;
    private final int REQUEST_IMAGE = 400;
    private String[] locationPermissions;
    double latitude=0.0,longitude=0.0;
    private LocationManager locationManager;
    FusedLocationProviderClient fusedLocationProviderClient;
    Bitmap bp=null;
    String attendance="";

    ApiServices apiServices;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAttendanceBinding.inflate(inflater,container,false);
        sharedPreferences= getActivity().getSharedPreferences("LoginDetails", MODE_PRIVATE);
        editor=sharedPreferences.edit();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        lastActivity=sharedPreferences.getString("lastActivity","");
        lastActivityDate=sharedPreferences.getString("lastActivityDate","");

        apiServices = ServiceGenerator.createService(ApiServices.class);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate = new android.icu.text.SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(new Date());
        }
        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        binding.cardAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setTitle("Are you Sure you want to punch out?")
                        .setMessage("Once you puch out you cannot \bPUNCH IN\b again for the day.")
                        .setCancelable(true)
                        .setPositiveButton("Punch out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                detectLocation();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
            }
        });

        binding.cardSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new AttendanceListFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Attendance List");
            }
        });




        return binding.getRoot();
    }
    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(getActivity(), locationPermissions, Location_Request_code);

    }


    @SuppressLint("MissingPermission")
    private void detectLocation() {

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission();
            return;
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            {
                fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        float[] results = new float[1];
                        try{
                            Location location = task.getResult();
                            if (location != null) {

                                try {
                                    Geocoder geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
                                    List<Address> addresses = geocoder.getFromLocation(
                                            location.getLatitude(), location.getLongitude(), 1


                                    );

                                    latitude = addresses.get(0).getLatitude();
                                    longitude = addresses.get(0).getLongitude();
//                                    Toast.makeText(getActivity(), "Your Lat/Long:::"+latitude+","+longitude, Toast.LENGTH_LONG).show();
                                    Log.e("AVGHCGHJGFHC",""+latitude);
                                    Log.e("AVGHCGHJGFHC",""+longitude);
                                    
                                        Location.distanceBetween(Utils.officeLatitude,Utils.officeLongitude,latitude,longitude,results);
                                        float distance=results[0];
                                        if(distance>1000){
                                            Toast.makeText(getActivity(), "You are "+distance+" m away from Office Location. Can't Punch Out.", Toast.LENGTH_SHORT).show();
                                        }else{
                                            savePunchOutAttendance();
                                        }

                                    









                                } catch (IOException e) {
                                    e.printStackTrace();

                                }

                            } else {

                                Toast.makeText(getActivity() ,"Unable to detect Your Location", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){


                        }



                    }
                });
            }
        } else {

            Toast.makeText(getActivity(), "Your Location is Turned Off.", Toast.LENGTH_SHORT).show();
            detectLocation();
        }
    }

    private void savePunchOutAttendance() {
        ApiServices apiServices = ServiceGenerator.createService(ApiServices.class);
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("LoginDetails", MODE_PRIVATE);
        String pkteacherId=sharedPreferences.getString("pkTeacherId","");
        String fkClassId=sharedPreferences.getString("fkClassId","");
        String fkSectionId=sharedPreferences.getString("fkSectionId","");
        String currentDate1 = null;
        String currentTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(new Date());
            currentTime = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Date());
        }

            JsonObject object = new JsonObject();
            object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );
            object.addProperty("OutLongitude", longitude);
            object.addProperty("OutLatiTude", latitude);
            Call<CommponPuchInPuchOutResponse> call = apiServices.SavePunchOutAttendance(object);
            String finalCurrentTime = currentTime;
            call.enqueue(new Callback<CommponPuchInPuchOutResponse>() {
                @Override
                public void onResponse(Call<CommponPuchInPuchOutResponse> call, Response<CommponPuchInPuchOutResponse> response) {
                    if(response.isSuccessful()){

                        if(response.body().getMessage().equals("   PunchOut Successfully !")){
                            final android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(getActivity());
                            View mView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_punch_successful, null);
                            alert.setView(mView);
                            TextView txt_message=mView.findViewById(R.id.txt_message);
                            TextView txt_date=mView.findViewById(R.id.txt_date);
                            TextView txt_time=mView.findViewById(R.id.txt_time);
                            TextView txt_latitude=mView.findViewById(R.id.txt_latitude);
                            TextView txt_longitude=mView.findViewById(R.id.txt_longitude);
                            TextView txt_address=mView.findViewById(R.id.txt_address);
                            Button btn_start=mView.findViewById(R.id.btn_start);
                            btn_start.setText("End Your Day");
                            txt_time.setText(response.body().getPunchOutTime());

                            txt_date.setText(response.body().getPunchOutDate());
                            txt_latitude.setText(""+latitude);
                            txt_longitude.setText(""+longitude);
                            txt_message.setText("Your Punch Out Successful was!!");
                            try {
                                Geocoder geocoder = new Geocoder(getActivity(), Locale.ENGLISH);
                                List<Address> addresses = geocoder.getFromLocation(
                                        latitude, longitude, 1


                                );
                                txt_address.setText(addresses.get(0).getAddressLine(0));


//                                    Toast.makeText(getActivity(), "Your Lat/Long:::"+latitude+","+longitude, Toast.LENGTH_LONG).show();
                                Log.e("AVGHCGHJGFHC",""+latitude);
                                Log.e("AVGHCGHJGFHC",""+longitude);







                            } catch (IOException e) {
                                e.printStackTrace();
                                txt_address.setText("-");

                            }

                            final android.app.AlertDialog alertDialog = alert.create();
                            alertDialog.show();



                            btn_start.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    editor.putString("lastActivity","out");
                                    editor.putString("lastActivityDate",currentDate);
                                    editor.apply();
                                    editor.commit();
                                    Fragment fragment=new PunchInFragment();
                                    ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Attendance");
                                    alertDialog.dismiss();
                                }
                            });

                        }else{
                            Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                        Log.e("TeacherId","5:: "+response.body());

                    }
                }

                @Override
                public void onFailure(Call<CommponPuchInPuchOutResponse> call, Throwable t) {

                }
            });
        }


    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setTitle( "Attendance");
    }
}