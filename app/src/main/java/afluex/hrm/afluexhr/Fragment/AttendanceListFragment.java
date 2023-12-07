package afluex.hrm.afluexhr.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.gson.JsonObject;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Adapter.AdapterAttendance;
import afluex.hrm.afluexhr.Model.ResponseAttendnace;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.databinding.FragmentAttendanceListBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AttendanceListFragment extends Fragment {
    FragmentAttendanceListBinding binding;

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
        binding=FragmentAttendanceListBinding.inflate(inflater,container,false);

        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);


        getAttendance();





        return binding.getRoot();
    }
    private void getAttendance() {
        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("LoginDetails", MODE_PRIVATE);
        String pkteacherId=sharedPreferences.getString("pkTeacherId","");
        String fkClassId=sharedPreferences.getString("fkClassId","");
        String fkSectionId=sharedPreferences.getString("fkSectionId","");


            JsonObject object = new JsonObject();
            object.addProperty("FK_EmpID", sharedPreferences.getString("EmployeeId","") );
            object.addProperty("FromDate", "" );
            object.addProperty("ToDate", "" );
            Call<ResponseAttendnace> call = apiServices.GetAttenndaceList(object);

            call.enqueue(new Callback<ResponseAttendnace>() {
                @Override
                public void onResponse(Call<ResponseAttendnace> call, Response<ResponseAttendnace> response) {
                    Log.e("Failure","1:::"+response.body().getMessage());
                    if(response.isSuccessful()&&response.body().getMessage().equals("Record Found.")){
                        AdapterAttendance adapterAttendance=new AdapterAttendance(getActivity(),response.body().getListAttenndace());
                        binding.rvLeave.setAdapter(adapterAttendance);

                    }
                }

                @Override
                public void onFailure(Call<ResponseAttendnace> call, Throwable t) {
                    Log.e("Failure",t.getMessage());

                }
            });
        }


    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setTitle( "Attendance Report");
    }
}