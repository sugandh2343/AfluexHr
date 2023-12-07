package afluex.hrm.afluexhr.Fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Adapter.AdapterLeaveCount;
import afluex.hrm.afluexhr.Model.CommonResponse;
import afluex.hrm.afluexhr.Model.ModelLeaveApplication;
import afluex.hrm.afluexhr.Model.ResponseLeaveApllication;
import afluex.hrm.afluexhr.Model.ResponseLogin;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.LoggerUtil;
import afluex.hrm.afluexhr.databinding.FragmentLeaveBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LeaveFragment extends Fragment {
    ApiServices apiServices;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FragmentLeaveBinding binding;

    String fromDate,toDate;

    private ArrayList<String> leaveArrayList;

    private final Calendar myCalendar = Calendar.getInstance();

    String selectedLeaveId;

    private ArrayList<ModelLeaveApplication> leaveApplicationArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentLeaveBinding.inflate(inflater,container,false);

        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        leaveArrayList=new ArrayList<>();
        leaveApplicationArrayList=new ArrayList<>();

        getLeaveCount();

        binding.txtLeaveReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(new LeaveReportFragment(),"Leave Report");
            }
        });









        binding.spinnerLeaveType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    selectedLeaveId=leaveApplicationArrayList.get(position-1).getLeaveID();

                    Log.e("selectedLeaveId",selectedLeaveId);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e("selectedLeaveId",selectedLeaveId);
            }
        });




        DatePickerDialog.OnDateSetListener date = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "dd/MM/yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            fromDate = sdf.format(myCalendar.getTime());
            Log.e("Date", "From:" + fromDate);
            updateLabel(binding.etFrom);


        };
        DatePickerDialog.OnDateSetListener date1 = (view, year, monthOfYear, dayOfMonth) -> {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "dd/MM/yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            toDate = sdf.format(myCalendar.getTime());
            Log.e("Date", "From:" + toDate);
            updateLabel(binding.etTo);

        };

        binding.etFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

//            try {
//                Date fDate = dateFormat.parse(siteCreatedDate);
//                Log.e("Parse Success","Success");
////                datePickerDialog.getDatePicker().setMinDate(fDate.getTime());
//            } catch (ParseException e) {
//                Log.e("ParseException",e.getMessage());
//                e.printStackTrace();
//            }

                datePickerDialog.show();
                String myFormat = "dd/MM/yyyy"; //In which you need put here
            }
        });

        binding.etTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() + 86400000);
                datePickerDialog.show();
                String myFormat = "dd/MM/yyyy"; //In which you need put here
            }
        });
        
        binding.btnApplyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.spinnerLeaveType.getSelectedItemPosition()==0){
                    Toast.makeText(getActivity(), "Select Leave Type", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(binding.etFrom.getText().toString())){
                    Toast.makeText(getActivity(), "Select From Date", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(binding.etTo.getText().toString())){
                    Toast.makeText(getActivity(), "Select To Date", Toast.LENGTH_SHORT).show();
                }else {
                    applyLeave();
                }
            }
        });
        // Inflate the layout for this fragment


        return binding.getRoot();
    }

    private void applyLeave() {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );
        object.addProperty("Remark",binding.etRemark.getText().toString() );
        object.addProperty("FromDate",binding.etFrom.getText().toString() );
        object.addProperty("ToDate",binding.etTo.getText().toString() );
        object.addProperty("LeaveID",selectedLeaveId);
        Log.e("LeaveIdSend",selectedLeaveId);
        Log.e("LeaveIdSend","1"+sharedPreferences.getString("EmployeeId",""));
        Log.e("LeaveIdSend","2"+binding.etFrom.getText().toString());
        Log.e("LeaveIdSend","3"+binding.etTo.getText().toString());

        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));

        LoggerUtil.logItem(object);
        Call<CommonResponse> call = apiServices.SaveLeaveApplication(object);
        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                Fragment fragment=new HomeFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Home");

                Log.e("LeavveError",response.body().getMessage());
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {

            }
        });
    }

    private void updateLabel(EditText etFrom) {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etFrom.setText(sdf.format(myCalendar.getTime()));
    }

    private void getLeaveCount() {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );

        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));
        object.addProperty("LeaveID","" );
        LoggerUtil.logItem(object);
        Call<ResponseLeaveApllication> call = apiServices.getLeaveApplication(object);
        call.enqueue(new Callback<ResponseLeaveApllication>() {
            @Override
            public void onResponse(Call<ResponseLeaveApllication> call, Response<ResponseLeaveApllication> response) {
                if(response.isSuccessful()){
                    AdapterLeaveCount adapterLeaveCount=new AdapterLeaveCount(getActivity(),response.body().getLeaveApplicationArrayList());
                    binding.rvLeaveCount.setAdapter(adapterLeaveCount);





                    for(int i=0;i<response.body().getLeaveApplicationArrayList().size();i++){
                        leaveArrayList.add(response.body().getLeaveApplicationArrayList().get(i).getLeaveName());
                        leaveApplicationArrayList.add(response.body().getLeaveApplicationArrayList().get(i));
                    }

                    leaveArrayList.add(0,"Select Leave Type");

                    Log.e("EMPIDF",""+response.body().getLeaveApplicationArrayList().size());
                    Log.e("EMPIDF","L"+leaveApplicationArrayList.size());
                    ArrayAdapter<String> examinationArrayAdapter = new ArrayAdapter<String>
                            (getActivity(), android.R.layout.simple_spinner_item,
                                    leaveArrayList); //selected item will look like a spinner set from XML
                    examinationArrayAdapter.setDropDownViewResource(android.R.layout
                            .simple_spinner_dropdown_item);

                    binding.spinnerLeaveType.setAdapter(examinationArrayAdapter);
                    examinationArrayAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ResponseLeaveApllication> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setTitle( "Leave");
    }
}