package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.ModelComment;
import afluex.hrm.afluexhr.R;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.HolderComment> {
    private Context context;
    private ArrayList<ModelComment> commentArrayList;

    public AdapterComment(Context context, ArrayList<ModelComment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    @NonNull
    @Override
    public AdapterComment.HolderComment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_comment_single_row,parent,false);
        return new AdapterComment.HolderComment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterComment.HolderComment holder, int position) {
        ModelComment modelComment=commentArrayList.get(position);
        holder.txt_comment.setText(modelComment.getUserComment());
        holder.txt_user_name.setText(modelComment.getUserName());
        holder.img_user_cmt.setImageResource(modelComment.getUser_photo());

    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class HolderComment extends RecyclerView.ViewHolder {

        ImageView img_user_cmt;
        TextView txt_user_name,txt_comment;
        public HolderComment(@NonNull View itemView) {
            super(itemView);

            img_user_cmt=itemView.findViewById(R.id.img_user_cmt);
            txt_user_name=itemView.findViewById(R.id.txt_user_name);
            txt_comment=itemView.findViewById(R.id.txt_comment);
        }
    }
}
