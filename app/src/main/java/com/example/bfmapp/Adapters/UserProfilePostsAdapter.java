package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.UserPosts;

import java.util.ArrayList;

public class UserProfilePostsAdapter extends RecyclerView.Adapter<UserProfilePostsAdapter.ViewHolder> {

    public static final int SPAN_COUNT_ONE = 1;
    public static final int SPAN_COUNT_THREE = 3;

    public static final int viewtype_small = 1;
    public static final int viewtype_big = 2;

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
            return viewtype_big;
        }else {
            return viewtype_small;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == viewtype_big){
            view = LayoutInflater.from(context).inflate(R.layout.userlistpost,parent,false);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.usergridpost,parent,false);
        }
        return new ViewHolder(view,viewType);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userpostimg.setImageResource(postsArrayList.get(position).userpostimg);
//        if (getItemViewType(position) == viewtype_big){
//        }

    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userpostimg;


        public ViewHolder(@NonNull View itemView,int viewtype) {
            super(itemView);

            if (viewtype == viewtype_big){

                userpostimg = itemView.findViewById(R.id.userlistpost_img);
            }else {
                userpostimg = itemView.findViewById(R.id.usergridpost_img);
            }
        }
    }
}
