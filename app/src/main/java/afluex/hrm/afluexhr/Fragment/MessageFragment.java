package afluex.hrm.afluexhr.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.Date;
import java.util.Locale;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Adapter.AdapterMessage;
import afluex.hrm.afluexhr.Model.CommonResponse;
import afluex.hrm.afluexhr.Model.ResponseLeaveApllication;
import afluex.hrm.afluexhr.Model.ResponseMessageList;
import afluex.hrm.afluexhr.Model.lstList;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.LoggerUtil;
import afluex.hrm.afluexhr.databinding.FragmentHomeBinding;
import afluex.hrm.afluexhr.databinding.FragmentMessageBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageFragment extends Fragment {
    FragmentMessageBinding binding;
    String currentDate=null;

    ApiServices apiServices;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         binding= FragmentMessageBinding.inflate(inflater,container,false);

        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate = new android.icu.text.SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(new Date());

        }

        getMessageList();


        binding.btnGenerateTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(binding.etRemark.getText().toString())){
                    Toast.makeText(getActivity(), "Message Field can't be left blank", Toast.LENGTH_SHORT).show();
                }else{
                    saveMessage();
                }
            }
        });





         return binding.getRoot();
    }

    private void saveMessage() {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );
        object.addProperty("LoginID",sharedPreferences.getString("LoginID","") );
        object.addProperty("NewMessage",binding.etRemark.getText().toString() );

        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));
        object.addProperty("MessageStatus","" );
        LoggerUtil.logItem(object);
        Call<CommonResponse> call = apiServices.SaveMessage(object);
        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    getMessageList();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {

            }
        });
    }

    private void getMessageList() {
        JsonObject object = new JsonObject();
        object.addProperty("EmployeeID",sharedPreferences.getString("EmployeeId","") );

        Log.e("EmployeeID",sharedPreferences.getString("EmployeeId",""));
        object.addProperty("MessageStatus","" );
        LoggerUtil.logItem(object);
        Call<ResponseMessageList> call = apiServices.MessagesList(object);

        call.enqueue(new Callback<ResponseMessageList>() {
            @Override
            public void onResponse(Call<ResponseMessageList> call, Response<ResponseMessageList> response) {
                if(response.isSuccessful()){
                    AdapterMessage adapterMessage=new AdapterMessage(getActivity(),response.body().getLstList());
                    binding.rvLeaveCount.setAdapter(adapterMessage);
                }
            }

            @Override
            public void onFailure(Call<ResponseMessageList> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setTitle( "Message");
    }
}