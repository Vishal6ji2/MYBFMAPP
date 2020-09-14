package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.ProposalsActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.AllFragSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class AllFragAdapter extends RecyclerView.Adapter<AllFragAdapter.ViewHolder> {

    Context context;

    ArrayList<AllFragSuitcase> arrayList = new ArrayList<>();

    public AllFragAdapter(Context context, ArrayList<AllFragSuitcase> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragcustomlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.profileimg.setImageResource(arrayList.get(position).profleimg);

        holder.txtusername.setText(arrayList.get(position).username);

        holder.txtnoties.setText(arrayList.get(position).noties);
        holder.txttime.setText(arrayList.get(position).time);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProposalsActivity.class);
                intent.putExtra("username",arrayList.get(position).username);
                intent.putExtra("userprofileimg",arrayList.get(position).profleimg);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircularImageView profileimg;
        TextView txtnoties,txttime,txtusername;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txttime = itemView.findViewById(R.id.frag_txttime);
            txtnoties = itemView.findViewById(R.id.frag_txtlines);
            profileimg = itemView.findViewById(R.id.frag_profileimg);
            txtusername = itemView.findViewById(R.id.frag_username);

        }
    }
}
