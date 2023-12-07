package afluex.hrm.afluexhr.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import afluex.hrm.afluexhr.databinding.ActivityMainBinding;

public class SplashActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if((getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("Name","")!=null)&&
                                    !(getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("Name","").equals(""))){
                                startActivity(new Intent(SplashActivity.this,DashboardActivity.class));
                                finish();
                            }else{
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                                finish();
                            }

                        }
                    });




                }
            }
        };

        timer.start();



    }
}