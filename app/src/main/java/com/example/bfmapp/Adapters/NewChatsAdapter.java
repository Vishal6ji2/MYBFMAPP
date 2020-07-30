package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.ChatMessagesActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class NewChatsAdapter extends RecyclerView.Adapter<NewChatsAdapter.ViewHolder> {

    Context context;
    ArrayList<NewChatsSuitcase> newChatsSuitcaseArrayList = new ArrayList<>();


    public NewChatsAdapter(Context context, ArrayList<NewChatsSuitcase> newChatsSuitcaseArrayList) {
        this.context = context;
        this.newChatsSuitcaseArrayList = newChatsSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.newcontactslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.chatselected.setVisibility(View.INVISIBLE);

        holder.chatnametxt.setText(newChatsSuitcaseArrayList.get(position).newchatname);

        holder.chatprofileimg.setImageResource(newChatsSuitcaseArrayList.get(position).newchatimg);


        holder.chatlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ChatMessagesActivity.class);
                intent.putExtra("chattername",newChatsSuitcaseArrayList.get(position).newchatname);
                intent.putExtra("chatterimg",newChatsSuitcaseArrayList.get(position).newchatimg);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newChatsSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chatnametxt;
        CircularImageView chatprofileimg;
        AppCompatCheckBox chatselected;
        LinearLayout chatlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chatnametxt = itemView.findViewById(R.id.newc_nametxt);
            chatprofileimg = itemView.findViewById(R.id.newc_profileimg);
            chatselected = itemView.findViewById(R.id.newc_checkbox);
            chatlayout = itemView.findViewById(R.id.newc_layout);

        }
    }
}
