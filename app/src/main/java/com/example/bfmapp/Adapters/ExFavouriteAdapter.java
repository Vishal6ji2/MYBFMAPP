package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ExPopularSuitcase;

import java.util.ArrayList;

public class ExFavouriteAdapter extends RecyclerView.Adapter<ExFavouriteAdapter.ViewHolder> {
    Context context;
    ArrayList<ExPopularSuitcase> favsuitcasearraylist = new ArrayList<>();
    ViewPager2 viewPager2;


    public ExFavouriteAdapter(Context context, ArrayList<ExPopularSuitcase> favsuitcasearraylist,ViewPager2 viewPager2) {
        this.viewPager2 = viewPager2;
        this.context = context;
        this.favsuitcasearraylist = favsuitcasearraylist;
    }

    @NonNull
    @Override
    public ExFavouriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.exfavouritelayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExFavouriteAdapter.ViewHolder holder, int position) {

        holder.favimages.setImageResource(favsuitcasearraylist.get(position).popularimages);

    }

    @Override
    public int getItemCount() {
        return favsuitcasearraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favimages;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            favimages = itemView.findViewById(R.id.expopular_img);
        }
    }
}
