package afluex.hrm.afluexhr.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Calendar;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Adapter.AdapterLeaveCount;
import afluex.hrm.afluexhr.Adapter.AdapterLeaveReport;
import afluex.hrm.afluexhr.Model.ModelLeaveApplication;
import afluex.hrm.afluexhr.Model.ResponseLeaveApllication;
import afluex.hrm.afluexhr.Model.ResponseLeaveReportForEmployeeBy;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.LoggerUtil;
import afluex.hrm.afluexhr.databinding.FragmentLeaveReportBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaveReportFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    FragmentLeaveReportBinding binding;
    ApiServices apiServices;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private ArrayList<String> status;

    private ArrayList<String> leaveArrayList;

    private final Calendar myCalendar = Calendar.getInstance();

    String selectedLeaveId;

    private ArrayList<ModelLeaveApplication> leaveApplicationArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        binding=FragmentLeaveReportBinding.inflate(inflater,container,false);

        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);

        leaveArrayList=new ArrayList<>();
        leaveApplicationArrayList=new ArrayList<>();
        status=new ArrayList<>();

        getLeaveCount();


        status.add("All");
        status.add("Pending");
        status.add("Approved");
        status.add("Declined");

        ArrayAdapter<String> examinationArrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_spinner_item,
                        status); //selected item will look like a spinner set from XML
        examinationArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);

        binding.spinnerLeaveStatus.setAdapter(examinationArrayAdapter);
        examinationArrayAdapter.notifyDataSetChanged();


        getLeaveReport("All");





        return binding.getRoot();
    }

    private void getLeaveReport(String status) {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );
        object.addProperty("LeaveID","" );


        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));
        object.addProperty("LeaveID","" );
        LoggerUtil.logItem(object);
        Call<ResponseLeaveReportForEmployeeBy> call = apiServices.LeaveReportForEmployeeBy(object);
        call.enqueue(new Callback<ResponseLeaveReportForEmployeeBy>() {
            @Override
            public void onResponse(Call<ResponseLeaveReportForEmployeeBy> call, Response<ResponseLeaveReportForEmployeeBy> response) {
                if(response.isSuccessful()){
                    if(response.body().getLstleavereports().size()>0){
                        binding.rvLeaveReport.setVisibility(View.VISIBLE);
                        AdapterLeaveReport adapterLeaveReport=new AdapterLeaveReport(getActivity(),response.body().getLstleavereports());
                        binding.rvLeaveReport.setAdapter(adapterLeaveReport);
                    }else{
                        binding.rvLeaveReport.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseLeaveReportForEmployeeBy> call, Throwable t) {

            }
        });

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
        ((DashboardActivity)getActivity()).setTitle( "Leave Report");
    }
}