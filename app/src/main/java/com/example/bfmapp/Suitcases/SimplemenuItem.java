package com.example.bfmapp.Suitcases;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.bfmapp.Adapters.DrawerAdapter;
import com.example.bfmapp.R;

public class SimplemenuItem extends DrawerItem<SimplemenuItem.ViewHolder> {

    int selectedMenuicontint ,selectedMenunametint;
    int normalMenuicontint, normalMenunametint;
    Context context;

    Drawable menuicon;
    String menuname;

    public SimplemenuItem(Drawable menuicon, String menuname) {
        this.menuicon = menuicon;
        this.menuname = menuname;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menuitems,parent,false));
    }

    @Override
    public void bindviewholder(ViewHolder holder) {

        holder.menuname.setText(menuname);
        holder.menuicon.setImageDrawable(menuicon);

        holder.menuname.setTextColor(isChecked ? selectedMenunametint : normalMenunametint);
        holder.menuicon.setColorFilter(isChecked ? selectedMenuicontint : normalMenuicontint);

    }

    public SimplemenuItem withSelectedItemIconTint(int selectedItemIconTint){
        this.selectedMenuicontint = selectedItemIconTint;
        return this;
    }

    public SimplemenuItem withSelectedTextTint(int selectedItemTextTint) {
        this.selectedMenunametint = selectedItemTextTint;
        return this;
    }

    public SimplemenuItem withIconTint(int normalItemIconTint) {
        this.normalMenuicontint = normalItemIconTint;
        return this;
    }

    public SimplemenuItem withTextTint(int normalItemTextTint) {
        this.normalMenunametint = normalItemTextTint;
        return this;
    }

        public static class ViewHolder extends DrawerAdapter.ViewHolder {

        ImageView menuicon;
        TextView menuname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            menuicon = itemView.findViewById(R.id.menuicon);
            menuname = itemView.findViewById(R.id.menuname);
        }
    }
}
