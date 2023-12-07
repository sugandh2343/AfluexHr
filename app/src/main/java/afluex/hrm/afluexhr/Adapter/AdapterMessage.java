package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.lstList;
import afluex.hrm.afluexhr.R;

public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.HolderMessage> {
    private Context context;
    private ArrayList<lstList> messageArrayList;

    public AdapterMessage(Context context, ArrayList<lstList> messageArrayList) {
        this.context = context;
        this.messageArrayList = messageArrayList;
    }

    @NonNull
    @Override
    public AdapterMessage.HolderMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_message_single_row,parent,false);
        return new AdapterMessage.HolderMessage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMessage.HolderMessage holder, int position) {
        lstList messageList=messageArrayList.get(position);
        holder.txt_srNo.setText(""+(position+1));
        holder.txt_date.setText(messageList.getMessageDate());
        holder.txt_msg.setText(messageList.getMessage());
        holder.txt_reqNo.setText(messageList.getRequestCode());
        holder.txt_status.setText(messageList.getMessageStatus());

    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    public class HolderMessage extends RecyclerView.ViewHolder {
        TextView txt_srNo,txt_reqNo,txt_date,txt_msg,txt_status;
        public HolderMessage(@NonNull View itemView) {
            super(itemView);
            txt_srNo=itemView.findViewById(R.id.txt_srNo);
            txt_reqNo=itemView.findViewById(R.id.txt_reqNo);
            txt_date=itemView.findViewById(R.id.txt_date);
            txt_msg=itemView.findViewById(R.id.txt_msg);
            txt_status=itemView.findViewById(R.id.txt_status);
        }
    }
}
