package com.example.bfmapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmapp.Adapters.CategoryFragAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CategorySuitcase;

import java.util.ArrayList;

import static com.example.bfmapp.Adapters.CategoryFragAdapter.SPANGRIDTWO;

public class CategoryFragment extends Fragment {

    RecyclerView categoriesrecyclerview;

    ArrayList<CategorySuitcase> categorySuitcaseArrayList = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_category, container, false);;

        categoriesrecyclerview = view.findViewById(R.id.cafrag_recyclerview);

        addData("Blogger",R.drawable.bloggerimg);
        addData("Film maker",R.drawable.filmmakerimg);
        addData("Designer",R.drawable.designerimg);
        addData("Director",R.drawable.directorimg);
        addData("Photographer",R.drawable.photographerimages);
        addData("Vlogger",R.drawable.vloggerimg);
        addData("Editor",R.drawable.editorimg);
        addData("Musician",R.drawable.musicianimg);
        addData("Writer",R.drawable.writerimg);
        addData("VFX",R.drawable.vfximg);
        addData("Animation",R.drawable.animationimg);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),SPANGRIDTWO);

        categoriesrecyclerview.setHasFixedSize(true);
        categoriesrecyclerview.setNestedScrollingEnabled(false);
        categoriesrecyclerview.setLayoutManager(gridLayoutManager);
        categoriesrecyclerview.setAdapter(new CategoryFragAdapter(getContext(),categorySuitcaseArrayList,gridLayoutManager));

        return view;
    }


    public void addData(String categoryname, int categoryimg){

        CategorySuitcase categorySuitcase = new CategorySuitcase();
        categorySuitcase.categoryname = categoryname;
        categorySuitcase.categoryimg = categoryimg;

        categorySuitcaseArrayList.add(categorySuitcase);
    }

}
