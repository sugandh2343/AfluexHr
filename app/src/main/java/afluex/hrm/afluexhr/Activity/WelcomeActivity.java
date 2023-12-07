package afluex.hrm.afluexhr.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Adapter.SliderAdapter;
import afluex.hrm.afluexhr.Model.SliderData;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {
    ActivityWelcomeBinding binding;

    private ArrayList<SliderData> sliderData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sliderData=new ArrayList<>();
        sliderData.add(new SliderData("", R.drawable.slider1));
        sliderData.add(new SliderData("", R.drawable.slider1));
        sliderData.add(new SliderData("", R.drawable.slider1));
        SliderAdapter adapter = new SliderAdapter(WelcomeActivity.this, sliderData);
        binding.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        binding.slider.setSliderAdapter(adapter);
        binding.slider.setScrollTimeInSec(5);
        binding.slider.setAutoCycle(true);
        binding.slider.startAutoCycle();


        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,ChooseRoleActivity.class));
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
            }
        });

    }
}