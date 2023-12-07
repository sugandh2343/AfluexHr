package afluex.hrm.afluexhr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import afluex.hrm.afluexhr.Model.ModelPost;
import afluex.hrm.afluexhr.R;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.HolderPost> {

    private Context context;
    private ArrayList<ModelPost> posts;

    public AdapterPost(Context context, ArrayList<ModelPost> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public AdapterPost.HolderPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.psot_single_row,parent,false);
        return new AdapterPost.HolderPost(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPost.HolderPost holder, int position) {

        ModelPost modelPost = posts.get(position);

        if(modelPost.getType().equals("Image")){
            holder.ll_image.setVisibility(View.VISIBLE);
            holder.txt_post.setVisibility(View.GONE);
            holder.img_post.setImageResource(modelPost.getImage());
        }else{
            holder.ll_image.setVisibility(View.GONE);
            holder.txt_post.setVisibility(View.VISIBLE);
          holder.txt_post.setText(modelPost.getText());
        }

        holder.iv_user_photo.setImageResource(modelPost.getImageUser());
        holder.txt_userName.setText(modelPost.getUserName());
        holder.txt_postTime.setText(modelPost.getPostDate());
        holder.txt_like.setText(modelPost.getLikeCount()+" Likes");
        holder.txt_comment.setText(modelPost.getCommentCount()+ " Comments");
        holder.txt_date.setText(modelPost.getDate());
        holder.txt_caption.setText(modelPost.getCaption());
        AdapterComment adapterComment=new AdapterComment(context,modelPost.getCommentArrayList());
        holder.rv_comment.setAdapter(adapterComment);



    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class HolderPost extends RecyclerView.ViewHolder {

        ImageView img_post,iv_user_photo;
        TextView txt_userName,txt_postTime,txt_caption,txt_post,txt_date,txt_like,txt_comment;
        LinearLayout ll_image;

        RecyclerView rv_comment;
        public HolderPost(@NonNull View itemView) {
            super(itemView);
            img_post=itemView.findViewById(R.id.img_post);
            iv_user_photo=itemView.findViewById(R.id.iv_user_photo);
            txt_userName=itemView.findViewById(R.id.txt_userName);
            txt_postTime=itemView.findViewById(R.id.txt_postTime);
            txt_caption=itemView.findViewById(R.id.txt_caption);
            txt_post=itemView.findViewById(R.id.txt_post);
            txt_date=itemView.findViewById(R.id.txt_date);
            txt_like=itemView.findViewById(R.id.txt_like);
            txt_comment=itemView.findViewById(R.id.txt_comment);
            ll_image=itemView.findViewById(R.id.ll_image);
            rv_comment=itemView.findViewById(R.id.rv_comment);

        }
    }
}
