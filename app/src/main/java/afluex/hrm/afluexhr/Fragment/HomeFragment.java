package afluex.hrm.afluexhr.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Activity.DashboardActivity;
import afluex.hrm.afluexhr.Adapter.AdapterPost;
import afluex.hrm.afluexhr.Model.ModelComment;
import afluex.hrm.afluexhr.Model.ModelPost;
import afluex.hrm.afluexhr.R;
import afluex.hrm.afluexhr.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    private ArrayList<ModelPost> postArrayList;

    private ArrayList<ModelComment> commentArrayList;
    private ArrayList<ModelComment> commentArrayList1;
    private ArrayList<ModelComment> commentArrayList2;
    private ArrayList<ModelComment> commentArrayList3;
    private ArrayList<ModelComment> commentArrayList4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false);


        //TODO POST MODEL

//        postArrayList=new ArrayList<>();
//
//        commentArrayList=new ArrayList<>();
//        commentArrayList1=new ArrayList<>();
//        commentArrayList2=new ArrayList<>();
//        commentArrayList3=new ArrayList<>();
//        commentArrayList4=new ArrayList<>();
//
//
//        commentArrayList.add(new ModelComment(R.drawable.profile_round,"Sugandh","Nice Photo"));
//        commentArrayList.add(new ModelComment(R.drawable.profile_round,"Saurabh","Great"));
//        commentArrayList.add(new ModelComment(R.drawable.profile_round,"Rakesh","Nice Photo"));
//        commentArrayList.add(new ModelComment(R.drawable.profile_round,"Surbhi","Nice Photo"));
//        commentArrayList1.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList1.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList2.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList2.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList2.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList3.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList3.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList3.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        commentArrayList3.add(new ModelComment(R.drawable.profile_round,"ABC","Nice Photo"));
//        postArrayList.add(new ModelPost(
//                "Image",
//                "",
//                "23-Jan-2023 11:49PM",
//                "MY First Post",
//                "15",
//                "32",
//                "Sugandh",
//                "uploaded 10 Minutes ago",
//                R.drawable.photo2,
//                R.drawable.profile_round,commentArrayList));
//        postArrayList.add(new ModelPost(
//                "Text",
//                "This is my first post",
//                "23-Jan-2023 11:49PM",
//                "MY First Post",
//                "150",
//                "2",
//                "Saurabh",
//                "uploaded 25 Minutes ago",
//                R.drawable.photo2,
//                R.drawable.profile_round,commentArrayList1));
// postArrayList.add(new ModelPost(
//                "Image",
//                "",
//                "23-Jan-2023 11:49PM",
//                "MY Second Post",
//                "151",
//                "0",
//                "Sugandh",
//                "uploaded 1 Hour ago",
//                R.drawable.photo2,
//                R.drawable.profile_round,commentArrayList2));
// postArrayList.add(new ModelPost(
//                "Image",
//                "",
//                "23-Jan-2023 11:49PM",
//                "MY First Post",
//                "15",
//                "32",
//                "Sugandh",
//                "Just Now",
//                R.drawable.photo2,
//                R.drawable.profile_round,commentArrayList3));
// postArrayList.add(new ModelPost(
//                "Text",
//                "",
//                "23-Jan-2023 11:49PM",
//                "MY First Post",
//                "15",
//                "32",
//                "Sugandh",
//                "uploaded 10 Minutes ago",
//                R.drawable.photo2,
//                R.drawable.profile_round,commentArrayList4));


        binding.cardAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new AttendanceFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Attendance");
            }
        });


        binding.cardLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new LeaveFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Leave");
            }
        });

        binding.cardMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new MessageFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Message");
            }
        });

        binding.cardSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new SalaryFragment();
                ((DashboardActivity)getActivity()).switchFragmentOnDashBoard(fragment, "Salary");
            }
        });












        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((DashboardActivity)getActivity()).setTitle( "Home");
    }
}