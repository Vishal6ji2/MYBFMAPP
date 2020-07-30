package com.example.bfmapp.Adapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Suitcases.DrawerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    List<DrawerItem> itemArrayList ;

    Map<Class<? extends DrawerItem>,Integer> viewtypes;

    SparseArray<DrawerItem> holderFactories;

    OnItemSelectedListener listener;


    public DrawerAdapter(List<DrawerItem> itemArrayList) {
        this.itemArrayList = itemArrayList;
        this.viewtypes = new HashMap<>();
        this.holderFactories = new SparseArray<>();

        processViewTypes();
    }


    @NonNull
    @Override

    public DrawerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder viewholder = holderFactories.get(viewType).createViewHolder(parent);
        viewholder.drawerAdapter = this;
        return viewholder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(@NonNull  DrawerAdapter.ViewHolder holder, int position) {

        itemArrayList.get(position).bindviewholder(holder);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    private void processViewTypes() {
        int type = 0;
        for (DrawerItem item : itemArrayList) {
            if (!viewtypes.containsKey(item.getClass())) {
                viewtypes.put(item.getClass(), type);
                holderFactories.put(type, item);
                type++;
            }
        }
    }

    public void setSelected(int position) {
        DrawerItem newChecked = itemArrayList.get(position);
        if (!newChecked.isSelectable()) {
            return;
        }

        for (int i = 0; i < itemArrayList.size(); i++) {
            DrawerItem item = itemArrayList.get(i);
            if (item.isChecked()) {
                item.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }

        newChecked.setChecked(true);
        notifyItemChanged(position);

        if (listener != null) {
            listener.onItemSelected(position);
        }
    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        DrawerAdapter drawerAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            drawerAdapter.setSelected(getAdapterPosition());
        }
    }

    public interface OnItemSelectedListener{
        void onItemSelected(int position);
    }
}
