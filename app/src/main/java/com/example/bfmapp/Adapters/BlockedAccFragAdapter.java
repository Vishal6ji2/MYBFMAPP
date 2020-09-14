package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.BlockedAccountSuitcase;
import com.google.android.material.button.MaterialButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class BlockedAccFragAdapter extends RecyclerView.Adapter<BlockedAccFragAdapter.ViewHolder> {

    Context context;
    ArrayList<BlockedAccountSuitcase> blockedAccountSuitcaseArrayList = new ArrayList<>();

    public BlockedAccFragAdapter(Context context, ArrayList<BlockedAccountSuitcase> blockedAccountSuitcaseArrayList) {
        this.context = context;
        this.blockedAccountSuitcaseArrayList = blockedAccountSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.blockedacclayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.blockedname.setText(blockedAccountSuitcaseArrayList.get(position).blockedname);
        holder.blockedprofileimg.setImageResource(blockedAccountSuitcaseArrayList.get(position).blockedprofileimg);
        blockedAccountSuitcaseArrayList.get(position).blockedbtn = holder.btnunblock;

        blockedAccountSuitcaseArrayList.get(position).blockedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockedAccountSuitcaseArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return blockedAccountSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView blockedname;
        CircularImageView blockedprofileimg;
        MaterialButton btnunblock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            blockedname = itemView.findViewById(R.id.blocked_txtname);
            blockedprofileimg = itemView.findViewById(R.id.blocked_profileimg);
            btnunblock = itemView.findViewById(R.id.blocked_btnunblock);
        }
    }
}
