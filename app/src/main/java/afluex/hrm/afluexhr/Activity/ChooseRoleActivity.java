package afluex.hrm.afluexhr.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.databinding.ActivityChooseRoleBinding;

public class ChooseRoleActivity extends AppCompatActivity {
    ActivityChooseRoleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChooseRoleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}