package com.example.bfmapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bfmapp.Adapters.AllFragAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.AllFragSuitcase;

import java.util.ArrayList;


public class AllFragment extends Fragment {

    View layoutview;

    RecyclerView todayrecyclerview,yestrecyclerview,weekrecyclerview;

    TextView txttoday,txtyesterday,txtweek;

    ArrayList<AllFragSuitcase> fragTodayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragyesterdayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragweekarrayList = new ArrayList<>();

    public AllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutview = inflater.inflate(R.layout.fragment_all, container, false);

        initviews();


        txtweek.setVisibility(View.INVISIBLE);

        addTodayData(R.drawable.profilefive,"Dj kori also commented on Dimple's topic: U can talk to me and 9 more comments","10m");
        addTodayData(R.drawable.profiletwo,"Dimple also commented on Corona","59m");
        addTodayData(R.drawable.profilethree,"Annathesia liked your picture","23h");

        todayrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        todayrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragTodayarrayList));
        todayrecyclerview.smoothScrollToPosition(fragTodayarrayList.size());

        addYestData(R.drawable.profilefive,"Dj kori also commented on Dimple's topic: U can talk to me and 9 more comments","10m");
        addYestData(R.drawable.profilefive,"Dj kori also commented on Dimple's topic: U can talk to me and 9 more comments","10m");


        yestrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        yestrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragyesterdayarrayList));
        yestrecyclerview.smoothScrollToPosition(fragyesterdayarrayList.size());

        return layoutview;
    }

    private void initviews() {

        todayrecyclerview = layoutview.findViewById(R.id.allnoti_todayrecyclerview);
        yestrecyclerview = layoutview.findViewById(R.id.allnoti_yesterdayrecyclerview);
        weekrecyclerview = layoutview.findViewById(R.id.allnoti_weekrecyclerview);


        txttoday = layoutview.findViewById(R.id.allnoti_txttoday);
        txtyesterday = layoutview.findViewById(R.id.allnoti_txtyesterday);
        txtweek = layoutview.findViewById(R.id.allnoti_txtweek);

    }

    public void addTodayData(int profileimg,String noties,String time){
        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.time = time;

        fragTodayarrayList.add(allFragSuitcase);
    }


    public void addYestData(int profileimg,String noties,String time){

        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.time = time;

        fragyesterdayarrayList.add(allFragSuitcase);

    }

}
