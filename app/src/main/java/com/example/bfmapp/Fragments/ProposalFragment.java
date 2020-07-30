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

public class ProposalFragment extends Fragment {

    View layoutview;

    RecyclerView todayrecyclerview,yestrecyclerview,weekrecyclerview;

    TextView txttoday,txtyesterday,txtweek;

    ArrayList<AllFragSuitcase> fragTodayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragyesterdayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragweekarrayList = new ArrayList<>();


    public ProposalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        layoutview = inflater.inflate(R.layout.fragment_proposal, container, false);

        initviews();

        txtweek.setVisibility(View.INVISIBLE);

    addTodayData(R.drawable.profilefive,"Annasthesia","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");
    addTodayData(R.drawable.profiletwo,"Jacksonblogs","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","59m");
    addTodayData(R.drawable.profilethree,"Felecita","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","23h");

        todayrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        todayrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragTodayarrayList));
        todayrecyclerview.smoothScrollToPosition(fragTodayarrayList.size());

    addYestData(R.drawable.profilefive,"Elinafonser","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");
    addYestData(R.drawable.profilefive,"Serenagomez","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");


        yestrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        yestrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragyesterdayarrayList));
        yestrecyclerview.smoothScrollToPosition(fragyesterdayarrayList.size());

        return layoutview;
}


    private void initviews() {

        todayrecyclerview = layoutview.findViewById(R.id.propnoti_todayrecyclerview);
        yestrecyclerview = layoutview.findViewById(R.id.propnoti_yesterdayrecyclerview);
        weekrecyclerview = layoutview.findViewById(R.id.propnoti_weekrecyclerview);


        txttoday = layoutview.findViewById(R.id.propnoti_txttoday);
        txtyesterday = layoutview.findViewById(R.id.propnoti_txtyesterday);
        txtweek = layoutview.findViewById(R.id.propnoti_txtweek);

    }

    public void addTodayData(int profileimg,String username,String noties,String time){
        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.username = username;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.time = time;

        fragTodayarrayList.add(allFragSuitcase);
    }


    public void addYestData(int profileimg,String username,String noties,String time){

        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.username = username;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.time = time;

        fragyesterdayarrayList.add(allFragSuitcase);

    }


}
