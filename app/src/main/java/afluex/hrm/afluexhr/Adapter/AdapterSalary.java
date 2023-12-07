package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.lstSalaryPaymentRepor;
import afluex.hrm.afluexhr.R;

public class AdapterSalary extends RecyclerView.Adapter<AdapterSalary.HolderSalary>{
    private Context context;
    private ArrayList<lstSalaryPaymentRepor> salaryPaymentReporArrayList;

    public AdapterSalary(Context context, ArrayList<lstSalaryPaymentRepor> salaryPaymentReporArrayList) {
        this.context = context;
        this.salaryPaymentReporArrayList = salaryPaymentReporArrayList;
    }

    @NonNull
    @Override
    public AdapterSalary.HolderSalary onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_salary_single_row,parent,false);
        return new AdapterSalary.HolderSalary(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSalary.HolderSalary holder, int position) {
        lstSalaryPaymentRepor salary=salaryPaymentReporArrayList.get(position);
        holder.txt_balance.setText(salary.getBalance());
        holder.txt_date.setText(salary.getPaymentDate());
        holder.txt_mode.setText(salary.getPaymentMode());
        holder.txt_net_salary.setText(salary.getNetSalary());
        holder.txt_paid_amt.setText(salary.getPaidAmount());

    }

    @Override
    public int getItemCount() {
        return salaryPaymentReporArrayList.size();
    }

    public class HolderSalary extends RecyclerView.ViewHolder {
        TextView txt_net_salary,txt_paid_amt,txt_balance,txt_date,txt_mode;
        public HolderSalary(@NonNull View itemView) {
            super(itemView);
            txt_net_salary=itemView.findViewById(R.id.txt_net_salary);
            txt_paid_amt=itemView.findViewById(R.id.txt_paid_amt);
            txt_balance=itemView.findViewById(R.id.txt_net_salary);
            txt_date=itemView.findViewById(R.id.txt_net_salary);
            txt_mode=itemView.findViewById(R.id.txt_net_salary);
        }
    }
}
