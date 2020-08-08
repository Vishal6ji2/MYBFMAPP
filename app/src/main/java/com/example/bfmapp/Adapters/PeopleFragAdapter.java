package com.example.bfmapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CategorySuitcase;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class PeopleFragAdapter extends RecyclerView.Adapter<PeopleFragAdapter.ViewHolder> {

    Context context;
    ArrayList<CategorySuitcase> suitcaseArrayList = new ArrayList<>();

    public PeopleFragAdapter(Context context, ArrayList<CategorySuitcase> suitcaseArrayList) {
        this.context = context;
        this.suitcaseArrayList = suitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.categorieschipslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.categorieschip.setText(suitcaseArrayList.get(position).categoryname);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked"+suitcaseArrayList.get(position).categoryname, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return suitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Chip categorieschip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categorieschip = itemView.findViewById(R.id.pecustom_chip);
        }
    }
}
