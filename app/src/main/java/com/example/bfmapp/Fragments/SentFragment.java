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

public class SentFragment extends Fragment {


    View layoutview;

    RecyclerView todayrecyclerview,yestrecyclerview,weekrecyclerview;

    TextView txttoday,txtyesterday,txtweek;

    ArrayList<AllFragSuitcase> fragTodayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragyesterdayarrayList = new ArrayList<>();

    ArrayList<AllFragSuitcase> fragweekarrayList = new ArrayList<>();



    public SentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layoutview = inflater.inflate(R.layout.fragment_sent, container, false);

        initviews();

        txtyesterday.setVisibility(View.INVISIBLE);

        addTodayData(R.drawable.profilefive,"Annasthesia","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");
        addTodayData(R.drawable.profiletwo,"Jacksonblogs","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","59m");
        addTodayData(R.drawable.profilethree,"Felecita","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","23h");

        todayrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        todayrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragTodayarrayList));
        todayrecyclerview.smoothScrollToPosition(fragTodayarrayList.size());

        addWeekdata(R.drawable.profilefive,"Elinafonser","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");
        addWeekdata(R.drawable.profilefive,"Serenagomez","I have read your blogs and they are extremely very good and most lovable your blogs thank you so much.","10m");


        weekrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        weekrecyclerview.setAdapter(new AllFragAdapter(getActivity(),fragweekarrayList));
        weekrecyclerview.smoothScrollToPosition(fragweekarrayList.size());

        return layoutview;
    }


    private void initviews() {

        todayrecyclerview = layoutview.findViewById(R.id.sentnoti_todayrecyclerview);
        yestrecyclerview = layoutview.findViewById(R.id.sentnoti_yesterdayrecyclerview);
        weekrecyclerview = layoutview.findViewById(R.id.sentnoti_weekrecyclerview);


        txttoday = layoutview.findViewById(R.id.sentnoti_txttoday);
        txtyesterday = layoutview.findViewById(R.id.sentnoti_txtyesterday);
        txtweek = layoutview.findViewById(R.id.sentnoti_txtweek);

    }

    public void addTodayData(int profileimg,String username,String noties,String time){
        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.time = time;
        allFragSuitcase.username = username;

        fragTodayarrayList.add(allFragSuitcase);
    }


    public void addWeekdata(int profileimg,String username,String noties,String time){

        AllFragSuitcase allFragSuitcase = new AllFragSuitcase();

        allFragSuitcase.noties = noties;
        allFragSuitcase.profleimg = profileimg;
        allFragSuitcase.username = username;
        allFragSuitcase.time = time;

        fragweekarrayList.add(allFragSuitcase);

    }
}
