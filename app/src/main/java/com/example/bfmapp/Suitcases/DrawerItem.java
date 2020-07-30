package com.example.bfmapp.Suitcases;

import android.view.ViewGroup;

import com.example.bfmapp.Adapters.DrawerAdapter;

public abstract class DrawerItem <T extends DrawerAdapter.ViewHolder> {

    boolean isChecked;

    public abstract T createViewHolder(ViewGroup parent);

    public abstract void bindviewholder(T holder);


    public DrawerItem setChecked(boolean isChecked){
        this.isChecked = isChecked;
        return this;
    }

    public boolean isChecked(){

        return isChecked;
    }

    public boolean isSelectable(){
        return true;
    }
}
