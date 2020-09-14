package com.example.bfmapp.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bfmapp.Adapters.BlockedAccFragAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.BlockedAccountSuitcase;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;


public class BlockedAccountsFragment extends Fragment {

    MaterialToolbar toolbar;
    RecyclerView blockedaccrecyclerview;
    View view;

    Bundle intent;

    ArrayList<BlockedAccountSuitcase> blockedAccountSuitcaseArrayList = new ArrayList<>();

    public BlockedAccountsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_blocked_accounts, container, false);

        initviews();

        /*if (intent!=null){
            if (intent.getString("blockedname")!=null){
                String blockedname = intent.getString("blockedname");
                int blockedimg = intent.getInt("blockedimg",R.drawable.passwordicon);
                addBlockeddata(blockedname,blockedimg);
            }
        }*/

        addBlockeddata("Kotlin ",R.drawable.girlone);
        addBlockeddata("Alison ",R.drawable.girltwo);
        addBlockeddata("James cameron ",R.drawable.girlthree);
        addBlockeddata("Wingle  ",R.drawable.profilefive);
        addBlockeddata("Antompson ",R.drawable.profileone);


        blockedaccrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        blockedaccrecyclerview.setItemAnimator(new DefaultItemAnimator());
//        blockedaccrecyclerview.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        blockedaccrecyclerview.setAdapter(new BlockedAccFragAdapter(getActivity(),blockedAccountSuitcaseArrayList));

        return view;
    }

    private void initviews() {

        intent = getArguments();

        toolbar = view.findViewById(R.id.blockedfrag_toolbar);
        blockedaccrecyclerview = view.findViewById(R.id.blockedfrag_recyclerview);

    }


    public void addBlockeddata(String blockedname,int blockedimg){

        BlockedAccountSuitcase blockedAccountSuitcase = new BlockedAccountSuitcase();
        blockedAccountSuitcase.blockedname = blockedname;
        blockedAccountSuitcase.blockedprofileimg = blockedimg;

        blockedAccountSuitcaseArrayList.add(blockedAccountSuitcase);
    }

}
