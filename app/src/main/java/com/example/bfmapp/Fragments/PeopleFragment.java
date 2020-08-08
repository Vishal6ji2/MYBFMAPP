package com.example.bfmapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmapp.Adapters.PeopleFragAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CategorySuitcase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    RecyclerView categoriesrecyclerview;

    ArrayList<CategorySuitcase> suitcaseArrayList = new ArrayList<>();

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        categoriesrecyclerview = view.findViewById(R.id.pefrag_recyclerview);

        addData("Photographer");
        addData("Editor");
        addData("Musician");
        addData("Writer");
        addData("Blogger");
        addData("Film maker");
        addData("Vlogger");
        addData("Designer");
        addData("Director");


        categoriesrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        categoriesrecyclerview.setAdapter(new PeopleFragAdapter(getContext(),suitcaseArrayList));

        return view;
    }


    public void addData(String categorieschip){
        CategorySuitcase categorySuitcase = new CategorySuitcase();
        categorySuitcase.categoryname = categorieschip;

        suitcaseArrayList.add(categorySuitcase);
    }
}
