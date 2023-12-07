package afluex.hrm.afluexhr.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.Locale;

import afluex.hrm.afluexhr.Fragment.AttendanceFragment;
import afluex.hrm.afluexhr.Fragment.AttendanceListFragment;
import afluex.hrm.afluexhr.Fragment.HomeFragment;
import afluex.hrm.afluexhr.Fragment.LeaveFragment;
import afluex.hrm.afluexhr.Fragment.MessageFragment;
import afluex.hrm.afluexhr.Fragment.PunchInFragment;
import afluex.hrm.afluexhr.Fragment.SalaryFragment;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.databinding.ActivityDashboardBinding;
import afluex.hrm.afluexhr.databinding.BottomLayoutBinding;
import afluex.hrm.afluexhr.databinding.CustomToolBarBinding;
import afluex.hrm.afluexhr.databinding.DrawaberNavigationViewLayoutBinding;

public class DashboardActivity extends AppCompatActivity   implements  NavigationView.OnNavigationItemSelectedListener {
    ActivityDashboardBinding binding;

    BottomLayoutBinding bottomLayoutBinding;


    CustomToolBarBinding topToolbarBinding;

    DrawaberNavigationViewLayoutBinding drawerBinding;
    String lastActivity="",lastActivityDate="";
    String currentDate=null;
    SharedPreferences.Editor editor;


    public ActionBarDrawerToggle drawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomLayoutBinding=binding.bottomLayout;
        topToolbarBinding=binding.toolbar;

        drawerBinding=binding.layoutNavigation;

        Fragment fragment=null;
//        topToolbarBinding.tvTHometitle.setText(getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("name",""));
//        String substring=getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("imagePath","").substring(2);
//        String link="http://hrms.afluex.com/"+substring;
//        Log.e("Title123",link);
        SharedPreferences sharedPreferences= getSharedPreferences("LoginDetails", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        lastActivity=sharedPreferences.getString("lastActivity","");
        lastActivityDate=sharedPreferences.getString("lastActivityDate","");

        topToolbarBinding.ivMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           switchFragmentOnDashBoard(new MessageFragment(),"Message");

            }
        });
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            currentDate = new android.icu.text.SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(new Date());
        }

        Log.e("LAshhv",lastActivity);
        Log.e("LAshhv",lastActivityDate);


        if(lastActivity.equals("")||lastActivityDate.equals("")||!lastActivityDate.equals(currentDate)||lastActivity.equals("out")){
         fragment=new PunchInFragment();
            switchFragmentOnDashBoard(fragment,"Attendance");
        }else{
         fragment=new HomeFragment();
            switchFragmentOnDashBoard(fragment,"Home");
        }

        topToolbarBinding.toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        drawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout,topToolbarBinding.toolbar,
                R.string.open,R.string.close);

        binding.drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.setDrawerIndicatorEnabled(false);
        binding.navigationView.setNavigationItemSelectedListener(this);
        topToolbarBinding.menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("MENUUUCLICK","CLICKED");
                checkDrawerOpen();

            }
        });

        topToolbarBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getBackStackEntryCount()>0){
                    onBackPressed();
                }else{
                    binding.drawerLayout.addDrawerListener(drawerToggle);
                    drawerToggle.setDrawerIndicatorEnabled(true);
                    drawerToggle.syncState();
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        drawerBinding.liLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(DashboardActivity.this,LoginActivity.class));
                finish();
            }
        });
        drawerBinding.assignTvName.setText(sharedPreferences.getString("Name",""));
        drawerBinding.liHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastActivity.equals("")||lastActivityDate.equals("")||!lastActivityDate.equals(currentDate)||lastActivity.equals("out")){

                    switchFragmentOnDashBoard(new PunchInFragment(),"Attendance");
                }else{

                    switchFragmentOnDashBoard(new HomeFragment(),"Home");
                }
                binding.drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

        drawerBinding.liBookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragmentOnDashBoard(new SalaryFragment(),"Salary");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        drawerBinding.liDownloadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragmentOnDashBoard(new LeaveFragment(),"Leave");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        drawerBinding.liAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragmentOnDashBoard(new MessageFragment(),"Message");
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });




        drawerToggle.syncState();
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        setSupportActionBar(topToolbarBinding.toolbar);


//        topToolbarBinding.imgProfile.setImageResource(R.drawable.profile_round);






        bottomLayoutBinding.ll1.setBackground(getDrawable(R.drawable.shape_rectangle_background));
        bottomLayoutBinding.ll2.setBackgroundColor(getColor(R.color.white));
        bottomLayoutBinding.ll3.setBackgroundColor(getColor(R.color.white));
        bottomLayoutBinding.ll4.setBackgroundColor(getColor(R.color.white));

        bottomLayoutBinding.ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLayoutBinding.ll1.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll2.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll3.setBackground(getDrawable(R.drawable.shape_rectangle_background));
                bottomLayoutBinding.ll4.setBackgroundColor(getColor(R.color.white));
                switchFragmentOnDashBoard(new MessageFragment(),"Message");
            }
        });


        bottomLayoutBinding.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("LAshhv",lastActivity);
                Log.e("LAshhv",lastActivityDate);
                bottomLayoutBinding.ll1.setBackground(getDrawable(R.drawable.shape_rectangle_background));
                bottomLayoutBinding.ll2.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll3.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll4.setBackgroundColor(getColor(R.color.white));
                if(lastActivity.equals("")||lastActivityDate.equals("")||!lastActivityDate.equals(currentDate)||lastActivity.equals("out")){

                    switchFragmentOnDashBoard(new PunchInFragment(),"Attendance");
                }else{

                    switchFragmentOnDashBoard(new HomeFragment(),"Home");
                }
            }
        });

        bottomLayoutBinding.ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLayoutBinding.ll1.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll2.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll3.setBackgroundColor(getColor(R.color.white));
                bottomLayoutBinding.ll4.setBackground(getDrawable(R.drawable.shape_rectangle_background));
                if(lastActivity.equals("")||lastActivityDate.equals("")||!lastActivityDate.equals(currentDate)||lastActivity.equals("out")){

                    switchFragmentOnDashBoard(new AttendanceListFragment(),"Attendance Report");
                }else{

                    switchFragmentOnDashBoard(new AttendanceFragment(),"Attendance");
                }
            }
        });

    }


    public void switchFragmentOnDashBoard(Fragment fragment, String name) {
        if(name.equals("Home")){
            topToolbarBinding.llUserDetails.setVisibility(View.VISIBLE);
            topToolbarBinding.txtPageName.setVisibility(View.GONE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                currentDate = new android.icu.text.SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(new Date());
                String currentDay=new android.icu.text.SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());

                topToolbarBinding.txtDate.setText(currentDay+" ,"+" "+ currentDate);
            }

            topToolbarBinding.txtUserName.setText(getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("Name",""));
            try{
                String substring=getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("imagePath","").substring(2);
                String link="http://demo4.afluex.com"+substring;
                Picasso.get().load(link).
                        resize(400,400).centerCrop()
                        .placeholder(R.drawable.profile_round)
                        .into(topToolbarBinding.imgProfile);


            }catch (Exception e){
                topToolbarBinding.imgProfile.setImageResource(R.drawable.profile_round);
            }
        }else{
            topToolbarBinding.llUserDetails.setVisibility(View.GONE);
            topToolbarBinding.txtPageName.setVisibility(View.VISIBLE);
            topToolbarBinding.txtPageName.setText(name);
        }







        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void checkDrawerOpen() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START);
        }
    }


    public void setTitle(String title){
        if(title.equals("Home")){
            topToolbarBinding.llUserDetails.setVisibility(View.VISIBLE);
            topToolbarBinding.txtPageName.setVisibility(View.GONE);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                currentDate = new android.icu.text.SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(new Date());
                String currentDay=new android.icu.text.SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());

                topToolbarBinding.txtDate.setText(currentDay+" ,"+" "+ currentDate);
            }

            topToolbarBinding.txtUserName.setText(getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("Name",""));
            try{
                String substring=getSharedPreferences("LoginDetails",MODE_PRIVATE).getString("imagePath","").substring(2);
                String link="http://demo4.afluex.com"+substring;
                Picasso.get().load(link).
                        resize(400,400).centerCrop()
                        .placeholder(R.drawable.profile_round)
                        .into(topToolbarBinding.imgProfile);


            }catch (Exception e){
                topToolbarBinding.imgProfile.setImageResource(R.drawable.profile_round);
            }
        }else{
            topToolbarBinding.llUserDetails.setVisibility(View.GONE);
            topToolbarBinding.txtPageName.setVisibility(View.VISIBLE);
            topToolbarBinding.txtPageName.setText(title);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}