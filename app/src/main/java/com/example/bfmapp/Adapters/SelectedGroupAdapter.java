package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.SelectGroupUserSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class SelectedGroupAdapter extends RecyclerView.Adapter<SelectedGroupAdapter.ViewHolder> {

    Context context;

    ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList = new ArrayList<>();

    public SelectedGroupAdapter(Context context, ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList) {
        this.context = context;
        this.chatsSuitcaseArrayList = chatsSuitcaseArrayList;
    }

    public SelectedGroupAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.newcontactslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.checkBox.setVisibility(View.INVISIBLE);
        holder.profileimg.setImageResource(chatsSuitcaseArrayList.get(position).profileimg);
        holder.username.setText(chatsSuitcaseArrayList.get(position).username);

    }

    @Override
    public int getItemCount() {
        return chatsSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        CircularImageView profileimg;
        AppCompatCheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.newc_checkbox);
            username = itemView.findViewById(R.id.newc_nametxt);
            profileimg = itemView.findViewById(R.id.newc_profileimg);
        }
    }
}
