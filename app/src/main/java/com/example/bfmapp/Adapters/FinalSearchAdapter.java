package com.example.bfmapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.OtherUsersProfileActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.FinalSearchSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class FinalSearchAdapter extends RecyclerView.Adapter<FinalSearchAdapter.ViewHolder> {

    Context context;
    ArrayList<FinalSearchSuitcase> searchSuitcaseArrayList = new ArrayList<>();

    public FinalSearchAdapter(Context context, ArrayList<FinalSearchSuitcase> searchSuitcaseArrayList) {
        this.context = context;
        this.searchSuitcaseArrayList = searchSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customsearchuserslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtusername.setText(searchSuitcaseArrayList.get(position).uname);
        holder.txtlocation.setText(searchSuitcaseArrayList.get(position).location);

        holder.profileimg.setImageResource(searchSuitcaseArrayList.get(position).profileimg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, OtherUsersProfileActivity.class);
                intent.putExtra("username",searchSuitcaseArrayList.get(position).uname);
                intent.putExtra("userimg",searchSuitcaseArrayList.get(position).profileimg);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchSuitcaseArrayList.size();
    }

    public void filteredlist(ArrayList<FinalSearchSuitcase> filterlist) {

        searchSuitcaseArrayList = filterlist;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircularImageView profileimg;
        TextView txtusername,txtlocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileimg = itemView.findViewById(R.id.fsl_profileimg);
            txtusername = itemView.findViewById(R.id.fsl_txtusername);
            txtlocation = itemView.findViewById(R.id.fsl_userlocationtxt);
        }
    }
}
