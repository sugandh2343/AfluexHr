package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.ModelLeaveApplication;
import afluex.hrm.afluexhr.R;

public class AdapterLeaveCount extends RecyclerView.Adapter<AdapterLeaveCount.HolderLeaveCount> {
    private Context context;
    private ArrayList<ModelLeaveApplication> leaveApplicationArrayList;

    public AdapterLeaveCount(Context context, ArrayList<ModelLeaveApplication> leaveApplicationArrayList) {
        this.context = context;
        this.leaveApplicationArrayList = leaveApplicationArrayList;
    }

    @NonNull
    @Override
    public AdapterLeaveCount.HolderLeaveCount onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_leave_count_single_row,parent,false);
        return new AdapterLeaveCount.HolderLeaveCount(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLeaveCount.HolderLeaveCount holder, int position) {
        ModelLeaveApplication leaveApplication=leaveApplicationArrayList.get(position);
        holder.txt_leave_type.setText(leaveApplication.getLeaveName());
        holder.txt_balance.setText(leaveApplication.getRemainingLeave());
        holder.txt_limit.setText(leaveApplication.getLeaveLimit());
        holder.txt_used.setText(leaveApplication.getUsedLeave());

    }

    @Override
    public int getItemCount() {
        return leaveApplicationArrayList.size();
    }

    public class HolderLeaveCount extends RecyclerView.ViewHolder {
        TextView txt_leave_type,txt_limit,txt_used,txt_balance;
        public HolderLeaveCount(@NonNull View itemView) {
            super(itemView);
            txt_leave_type=itemView.findViewById(R.id.txt_leave_type);
            txt_limit=itemView.findViewById(R.id.txt_limit);
            txt_used=itemView.findViewById(R.id.txt_used);
            txt_balance=itemView.findViewById(R.id.txt_balance);
        }
    }
}
