package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.OtherUsersProfileActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CommentsSuitcase;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    Context context;
    ArrayList<CommentsSuitcase> commentsSuitcaseArrayList = new ArrayList<>();

    public CommentsAdapter(Context context, ArrayList<CommentsSuitcase> commentsSuitcaseArrayList) {
        this.context = context;
        this.commentsSuitcaseArrayList = commentsSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cusomcommentlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.userprofileimg.setImageResource(commentsSuitcaseArrayList.get(position).userprofileimg);
        holder.txtUsername.setText(commentsSuitcaseArrayList.get(position).username);
        holder.txtcommentline.setText(commentsSuitcaseArrayList.get(position).commentlines);
        holder.txtcommenttime.setText(commentsSuitcaseArrayList.get(position).commenttime);
        holder.txtcommentlikes.setText(commentsSuitcaseArrayList.get(position).commentlikes);
        holder.txtcommentreplies.setText(commentsSuitcaseArrayList.get(position).commentreplies);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtherUsersProfileActivity.class);
                intent.putExtra("username",commentsSuitcaseArrayList.get(position).username);
                intent.putExtra("userimg",commentsSuitcaseArrayList.get(position).userprofileimg);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commentsSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtcommentlikes,txtcommentreplies,txtUsername,txtcommenttime,txtcommentline;
        ImageView commentlikeimg,commentrepliesimg,userprofileimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtcommentlikes = itemView.findViewById(R.id.customcomment_likestxt);
            txtcommentreplies = itemView.findViewById(R.id.customcomment_commentstxt);
            txtUsername = itemView.findViewById(R.id.customcomment_username);
            txtcommenttime = itemView.findViewById(R.id.customcomment_time);
            txtcommentline = itemView.findViewById(R.id.customcomment_commentline);

            commentlikeimg = itemView.findViewById(R.id.customcommentlikeimg);
            commentrepliesimg = itemView.findViewById(R.id.customcomment_commentimg);
            userprofileimg = itemView.findViewById(R.id.customcomment_profileimg);

        }
    }
}
