package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CategorySuitcase;

import java.util.ArrayList;

public class CategoryFragAdapter extends RecyclerView.Adapter<CategoryFragAdapter.ViewHolder> {

    Context context;
    ArrayList<CategorySuitcase> categorySuitcaseArrayList = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    public static final int SPANGRIDTWO = 2;

    public CategoryFragAdapter(Context context, ArrayList<CategorySuitcase> categorySuitcaseArrayList,GridLayoutManager gridLayoutManager) {
        this.context = context;
        this.categorySuitcaseArrayList = categorySuitcaseArrayList;
        this.gridLayoutManager = gridLayoutManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customcategorylayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.categoryname.setText(categorySuitcaseArrayList.get(position).categoryname);
        holder.categoryimg.setImageResource(categorySuitcaseArrayList.get(position).categoryimg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+categorySuitcaseArrayList.get(position).categoryname+"Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categorySuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryimg;
        TextView categoryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryimg = itemView.findViewById(R.id.cacustom_img);
            categoryname = itemView.findViewById(R.id.cacustom_name);

        }
    }
}
