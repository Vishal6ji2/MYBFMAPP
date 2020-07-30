package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.SelectGroupUsersActivity;
import com.example.bfmapp.Activities.SelectedGroupUsersActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.example.bfmapp.Suitcases.SelectGroupUserSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class SelectGroupAdapter extends RecyclerView.Adapter<SelectGroupAdapter.ViewHolder> {

    Context context;

    ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList = new ArrayList<>();
    ArrayList<SelectGroupUserSuitcase> selectedchatsarraylist ;

    public SelectGroupAdapter() {
    }

    public SelectGroupAdapter(Context context, ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList) {
        this.context = context;
        this.chatsSuitcaseArrayList = chatsSuitcaseArrayList;
        selectedchatsarraylist = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.newcontactslayout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.chatselected.setVisibility(View.VISIBLE);

        holder.chatnametxt.setText(chatsSuitcaseArrayList.get(position).username);
        holder.chatprofileimg.setImageResource(chatsSuitcaseArrayList.get(position).profileimg);

    }

    @Override
    public int getItemCount() {
        return chatsSuitcaseArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView chatnametxt;
        CircularImageView chatprofileimg;
        LinearLayout chatlayout;
        AppCompatCheckBox chatselected;

        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chatnametxt = itemView.findViewById(R.id.newc_nametxt);
            chatprofileimg = itemView.findViewById(R.id.newc_profileimg);
            chatselected = itemView.findViewById(R.id.newc_checkbox);
            chatlayout = itemView.findViewById(R.id.newc_layout);

            view = itemView;
            chatselected.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            SelectGroupUsersActivity.MakeSelection(v,getAdapterPosition());

        }
    }
}
