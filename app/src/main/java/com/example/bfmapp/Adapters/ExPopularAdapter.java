package com.example.bfmapp.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ExPopularSuitcase;

import java.util.ArrayList;

public class ExPopularAdapter extends RecyclerView.Adapter<ExPopularAdapter.ViewHolder> {
    Context context;
    ArrayList<ExPopularSuitcase> popularSuitcaseArrayList = new ArrayList<>();

    public ExPopularAdapter(Context context, ArrayList<ExPopularSuitcase> popularSuitcaseArrayList) {
        this.context = context;
        this.popularSuitcaseArrayList = popularSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.expopularlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
