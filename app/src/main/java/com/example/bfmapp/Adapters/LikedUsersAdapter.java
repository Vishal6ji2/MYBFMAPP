package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.OtherUsersProfileActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.LikedUsers;
import com.google.android.material.button.MaterialButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class LikedUsersAdapter extends RecyclerView.Adapter<LikedUsersAdapter.ViewHolder> {

    Context context;

    ArrayList<LikedUsers> likedUsersArrayList  = new ArrayList<>();

    public LikedUsersAdapter(Context context, ArrayList<LikedUsers> likedUsersArrayList) {
        this.context = context;
        this.likedUsersArrayList = likedUsersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.likeduserslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtusername.setText(likedUsersArrayList.get(position).likedusername);
        holder.profileimg.setImageResource(likedUsersArrayList.get(position).likedprofileimg);

        likedUsersArrayList.get(position).btnfollow = holder.btnfollow;

        likedUsersArrayList.get(position).btnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likedUsersArrayList.get(position).btnfollow.getText().equals("Follow")){
                    likedUsersArrayList.get(position).btnfollow.setText("Following");
                    likedUsersArrayList.get(position).btnfollow.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
                    likedUsersArrayList.get(position).btnfollow.setBackgroundTintList(context.getResources().getColorStateList(android.R.color.white));

                }else {
                    likedUsersArrayList.get(position).btnfollow.setText("Follow");
                    likedUsersArrayList.get(position).btnfollow.setTextColor(context.getResources().getColor(R.color.whitecolor));
                    likedUsersArrayList.get(position).btnfollow.setBackgroundTintList(context.getResources().getColorStateList(R.color.bluecolor));

                }
            }
        });

        holder.userslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtherUsersProfileActivity.class);
                intent.putExtra("username",likedUsersArrayList.get(position).likedusername);
                intent.putExtra("userimg",likedUsersArrayList.get(position).likedprofileimg);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return likedUsersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout userslayout;

        TextView txtusername;
        CircularImageView profileimg;
        MaterialButton btnfollow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userslayout = itemView.findViewById(R.id.lul_rlayout);
            txtusername = itemView.findViewById(R.id.lul_profilename);
            profileimg = itemView.findViewById(R.id.lul_profileimg);
            btnfollow = itemView.findViewById(R.id.lul_btnfollow);
        }
    }
}
