package com.example.bfmapp.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bfmapp.PlaceSuggestApi;

import java.util.ArrayList;

public class AutoPlaceSuggestAdapter extends ArrayAdapter implements Filterable {

    ArrayList<String> results;

    int resource;
    Context context;

    PlaceSuggestApi placeSuggestApi = new PlaceSuggestApi();

    public AutoPlaceSuggestAdapter(Context context,int resid){
        super(context,resid);

        this.context = context;
        this.resource = resid;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @NonNull
    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint!=null){
                    results = placeSuggestApi.autoComplete(constraint.toString());
                    filterResults.values = results;
                    filterResults.count = results.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                if (results!=null && results.count>0){
                    notifyDataSetChanged();
                }else {
                    notifyDataSetChanged();
                }
            }
        };

        return filter;
    }
}
