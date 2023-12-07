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

import com.google.gson.JsonObject;

import afluex.hrm.afluexhr.Adapter.AdapterSalary;
import afluex.hrm.afluexhr.Model.ResponseLeaveApllication;
import afluex.hrm.afluexhr.Model.ResponseSalaryPaymentReport;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.LoggerUtil;
import afluex.hrm.afluexhr.databinding.FragmentSalaryBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalaryFragment extends Fragment {
    FragmentSalaryBinding binding;

    ApiServices apiServices;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSalaryBinding.inflate(inflater,container,false);


        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);

        getSalaryReport();






        return binding.getRoot();
    }

    private void getSalaryReport() {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeName","" );
        object.addProperty("EmployeeCode",sharedPreferences.getString("LoginID","") );
        object.addProperty("FromDate","" );
        object.addProperty("ToDate","" );
        object.addProperty("PaymentMode","" );

        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));
        object.addProperty("LeaveID","" );
        LoggerUtil.logItem(object);
        Call<ResponseSalaryPaymentReport> call = apiServices.SalaryPaymentReport(object);
        call.enqueue(new Callback<ResponseSalaryPaymentReport>() {
            @Override
            public void onResponse(Call<ResponseSalaryPaymentReport> call, Response<ResponseSalaryPaymentReport> response) {
                if(response.isSuccessful()){
                    if(response.body().getStatus().equals("1")){
                        binding.llFound.setVisibility(View.VISIBLE);
                        binding.txtNoRecord.setVisibility(View.GONE);
                        AdapterSalary adapterSalary=new AdapterSalary(getActivity(),response.body().getLstSalaryPaymentRepor());
                        binding.rvLeaveCount.setAdapter(adapterSalary);
                    }else{
                        binding.llFound.setVisibility(View.GONE);
                        binding.txtNoRecord.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSalaryPaymentReport> call, Throwable t) {

            }
        });
    }
}