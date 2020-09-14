package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ExRecArtistSuitcase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class ExRecArtistAdapter extends RecyclerView.Adapter<ExRecArtistAdapter.ViewHolder> {

    Context context;
    ArrayList<ExRecArtistSuitcase> recArtistSuitcaseArrayList = new ArrayList<>();


    public ExRecArtistAdapter(Context context, ArrayList<ExRecArtistSuitcase> recArtistSuitcaseArrayList) {
        this.context = context;
        this.recArtistSuitcaseArrayList = recArtistSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.exrecartistlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.username.setText(recArtistSuitcaseArrayList.get(position).username);
        holder.profileimg.setImageResource(recArtistSuitcaseArrayList.get(position).profileimg);
        holder.lastpostimg.setImageResource(recArtistSuitcaseArrayList.get(position).lastpost);

    }

    @Override
    public int getItemCount() {
        return recArtistSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView lastpostimg;
        CircularImageView profileimg;
        TextView username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lastpostimg = itemView.findViewById(R.id.exrecartist_postimg);
            profileimg = itemView.findViewById(R.id.exrecartist_profileimg);
            username = itemView.findViewById(R.id.exrecartist_nametxt);
        }
    }
}
