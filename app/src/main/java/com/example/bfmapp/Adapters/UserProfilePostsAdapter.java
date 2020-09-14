package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.SinglePostActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.UserPosts;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class UserProfilePostsAdapter extends RecyclerView.Adapter<UserProfilePostsAdapter.ViewHolder> {

    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    public static final int viewtype_grid = 1;
    public static final int viewtype_list = 2;

    GridLayoutManager gridLayoutManager;

    Context context;
    ArrayList<UserPosts> postsArrayList = new ArrayList<>();



    public UserProfilePostsAdapter(Context context, ArrayList<UserPosts> postsArrayList,GridLayoutManager gridLayoutManager) {
        this.context = context;
        this.postsArrayList = postsArrayList;
        this.gridLayoutManager = gridLayoutManager;
    }


    @Override
    public int getItemViewType(int position) {
        int spancount = gridLayoutManager.getSpanCount();

        if (spancount == SPAN_COUNT_ONE){
            return viewtype_list;
        }else {
            return viewtype_grid;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == viewtype_list){
            view = LayoutInflater.from(context).inflate(R.layout.userlistpost,parent,false);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.usergridpost,parent,false);
        }
        return new ViewHolder(view,viewType);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.userpostimg.setImageResource(postsArrayList.get(position).userpostimg);

        if (getItemViewType(position) == viewtype_list){

            holder.profileimg.setImageResource(postsArrayList.get(position).profileimg);
            holder.txtusername.setText(postsArrayList.get(position).username);
            holder.txtposttime.setText(postsArrayList.get(position).posttime);
            holder.txtlocation.setText(postsArrayList.get(position).postlocation);
            holder.txtpostline.setText(postsArrayList.get(position).postlines);
            holder.txtlikes.setText(postsArrayList.get(position).likes);
            holder.txtcomments.setText(postsArrayList.get(position).comments);

        }else if (getItemViewType(position) == viewtype_grid){

            holder.userpostimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SinglePostActivity.class);
                    intent.putExtra("username",postsArrayList.get(position).username);
                    intent.putExtra("userprofileimg",postsArrayList.get(position).profileimg);
                    intent.putExtra("posttime",postsArrayList.get(position).posttime);
                    intent.putExtra("postlocation",postsArrayList.get(position).postlocation);

                    intent.putExtra("postimg",postsArrayList.get(position).userpostimg);
                    intent.putExtra("postlines",postsArrayList.get(position).postlines);
                    intent.putExtra("postlikes",postsArrayList.get(position).likes);
                    intent.putExtra("postcomments",postsArrayList.get(position).comments);

                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userpostimg,imglike,imgcomment,imgshare,imgbookmark;

        CircularImageView profileimg;
        TextView txtusername,txtposttime,txtlocation,txtlikes,txtcomments,txtpostline;


        public ViewHolder(@NonNull View itemView,int viewtype) {
            super(itemView);

            if (viewtype == viewtype_list){

                imglike = itemView.findViewById(R.id.userlistpost_imgblackheartlike);
                imgcomment = itemView.findViewById(R.id.userlistpost_imgcomment);
                imgshare = itemView.findViewById(R.id.userlistpost_imgshare);
                imgbookmark = itemView.findViewById(R.id.userlistpost_imgbookmark);
                userpostimg = itemView.findViewById(R.id.userlistpost_imgpost);

                profileimg = itemView.findViewById(R.id.userlistpost_imgprofile);
                txtusername = itemView.findViewById(R.id.userlistpost_txtname);
                txtposttime = itemView.findViewById(R.id.userlistpost_txttime);
                txtlocation = itemView.findViewById(R.id.userlistpost_txtlocation);
                txtlikes = itemView.findViewById(R.id.userlistpost_txtlikes);
                txtcomments = itemView.findViewById(R.id.userlistpost_txtcomments);
                txtpostline = itemView.findViewById(R.id.userlistpost_txtlines);

            }else {
                userpostimg = itemView.findViewById(R.id.usergridpost_img);
            }
        }
    }
}
