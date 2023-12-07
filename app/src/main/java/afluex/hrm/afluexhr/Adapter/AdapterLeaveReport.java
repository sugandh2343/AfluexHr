package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.lstleavereports;
import afluex.hrm.afluexhr.R;

public class AdapterLeaveReport extends RecyclerView.Adapter<AdapterLeaveReport.HolderLeaveReport> {

    private Context context;
    private ArrayList<lstleavereports> lstleavereports;

    private boolean open=false;

    public AdapterLeaveReport(Context context, ArrayList<afluex.hrm.afluexhr.Model.lstleavereports> lstleavereports) {
        this.context = context;
        this.lstleavereports = lstleavereports;
    }



    @NonNull
    @Override
    public AdapterLeaveReport.HolderLeaveReport onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_leave_report_single_row,parent,false);
        return new AdapterLeaveReport.HolderLeaveReport(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLeaveReport.HolderLeaveReport holder, int position) {
        lstleavereports lstleavereports1=lstleavereports.get(position);
        holder.txt_leave_type.setText(lstleavereports1.getLeaveName());
        holder.txt_from.setText(lstleavereports1.getFromDate());
        holder.txt_to.setText(lstleavereports1.getToDate());

        if(TextUtils.isEmpty(lstleavereports1.getRequestRemark())){
            holder.txt_remark.setText("-");
        }else{
            holder.txt_remark.setText(lstleavereports1.getRequestRemark());
        }


        if(lstleavereports1.getLeaveStatus().equals("Approved")){
            holder.view_details.setVisibility(View.VISIBLE);
            holder.txt_approved_heading.setText("Approved By:");
            holder.txt_status.setBackgroundColor(context.getColor(R.color.green_700));

        }else if(lstleavereports1.getLeaveStatus().equals("Declined")){
            holder.view_details.setVisibility(View.VISIBLE);
            holder.txt_approved_heading.setText("Declined By:");
            holder.txt_status.setBackgroundColor(context.getColor(R.color.red_700));

        }else{
            holder.txt_status.setBackgroundColor(context.getColor(R.color.blue_700));
            holder.view_details.setVisibility(View.GONE);

        }

        holder.txt_approved_name.setText(lstleavereports1.getApprovedBy());
        holder.txt_date.setText(lstleavereports1.getApprovedDate());
        holder.txt_from.setText(lstleavereports1.getFromDate());
        holder.txt_from.setText(lstleavereports1.getFromDate());

        holder.txt_status.setText(lstleavereports1.getLeaveStatus());
        holder.txt_status.setTextColor(context.getColor(R.color.white));


        holder.view_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(open){
                    holder.ll_approval.setVisibility(View.GONE);
                    open=false;
                }else{
                    holder.ll_approval.setVisibility(View.VISIBLE);
                    open=true;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return lstleavereports.size();
    }

    public class HolderLeaveReport extends RecyclerView.ViewHolder {
        TextView txt_leave_type,txt_from,txt_to,txt_remark,txt_status,txt_approved_heading,txt_approved_name,txt_date;
        View view_details;
        LinearLayout ll_approval;
        public HolderLeaveReport(@NonNull View itemView) {
            super(itemView);
            txt_leave_type=itemView.findViewById(R.id.txt_leave_type);
            txt_from=itemView.findViewById(R.id.txt_from);
            txt_to=itemView.findViewById(R.id.txt_to);
            txt_remark=itemView.findViewById(R.id.txt_remark);
            txt_status=itemView.findViewById(R.id.txt_status);
            txt_approved_heading=itemView.findViewById(R.id.txt_approved_heading);
            txt_approved_name=itemView.findViewById(R.id.txt_approved_name);
            txt_date=itemView.findViewById(R.id.txt_date);
            view_details=itemView.findViewById(R.id.view_details);
            ll_approval=itemView.findViewById(R.id.ll_approval);
        }
    }
}
