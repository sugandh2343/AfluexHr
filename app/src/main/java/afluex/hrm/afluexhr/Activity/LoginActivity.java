package afluex.hrm.afluexhr.Activity;

import static afluex.hrm.afluexhr.common.Utils.showMessage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.logging.Logger;

import afluex.hrm.afluexhr.Model.ResponseLogin;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.Retrofit.ApiServices;
import afluex.hrm.afluexhr.Retrofit.ServiceGenerator;
import afluex.hrm.afluexhr.common.LoggerUtil;
import afluex.hrm.afluexhr.common.NetworkUtils;
import afluex.hrm.afluexhr.databinding.ActivityLoginBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    ApiServices apiServices;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiServices = ServiceGenerator.createService(ApiServices.class);
        sharedPreferences=getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCanceledOnTouchOutside(false);
      binding.btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(NetworkUtils.getConnectivityStatus(LoginActivity.this)!=0){
                  progressDialog.show();
                  callLoginEmployee();
              }else{
                  showMessage(LoginActivity.this,"No Internet Connection");
              }
          }
      });
    }

    private void callLoginEmployee() {
        JsonObject object = new JsonObject();
        object.addProperty("LoginId",binding.etEmail.getText().toString() );
        object.addProperty("Password",binding.etPassword.getText().toString() );
        LoggerUtil.logItem(object);
        Call<ResponseLogin> call = apiServices.getLogin(object);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                progressDialog.dismiss();

                editor.putString("LoginID",response.body().getLoginID());
                editor.putString("EmployeeId",response.body().getPKEmployeeID());
                editor.putString("Name",response.body().getEmployeeName());
                editor.putString("Profile",response.body().getProfilePic());
                editor.putString("UserType",response.body().getUserType());

                editor.apply();
                editor.commit();

                startActivity(new Intent(LoginActivity.this,DashboardActivity.class));

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.e("Login Error",t.getMessage());

            }
        });
    }
}