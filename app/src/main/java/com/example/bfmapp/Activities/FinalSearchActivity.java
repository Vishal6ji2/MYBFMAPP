package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bfmapp.Adapters.FinalSearchAdapter;
import com.example.bfmapp.Adapters.NewChatsAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.FinalSearchSuitcase;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class FinalSearchActivity extends AppCompatActivity {


    RecyclerView usersrecyclerview;
    EditText edtsearch;

    MaterialToolbar materialToolbar;

    ImageView filterimg;

    ArrayList<FinalSearchSuitcase> searchSuitcaseArrayList = new ArrayList<>();

    FinalSearchAdapter finalSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_search);

        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addData("Dimple Leslie",R.drawable.profileone,"Noida");
        addData("Olivia",R.drawable.profiletwo,"Dubai");
        addData("Tery Leaon",R.drawable.profilethree,"Singapore");
        addData("Harry potter",R.drawable.profilefour,"Banglore");
        addData("Charles Babbage",R.drawable.profilefive,"Nadbai");
        addData("Noah Wright",R.drawable.profileone,"Pune");
        addData("Fred White",R.drawable.profiletwo,"Kawai");
        addData("Pearson joh",R.drawable.profilethree,"Piprau");
        addData("John marculas",R.drawable.profilefour,"Maxico");
        addData("Patakha Guddi",R.drawable.profilefive,"Pali");

        finalSearchAdapter = new FinalSearchAdapter(this,searchSuitcaseArrayList);

        usersrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        usersrecyclerview.setAdapter(finalSearchAdapter);


        filterimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FinalSearchActivity.this, "Filter work in process", Toast.LENGTH_SHORT).show();
            }
        });

        edtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });

    }

    private void filter(String text) {

        ArrayList<FinalSearchSuitcase> filterlist = new ArrayList<>();

        for (FinalSearchSuitcase searchSuitcase :searchSuitcaseArrayList){
            if (searchSuitcase.uname.toLowerCase().contains(text.toLowerCase())){
                filterlist.add(searchSuitcase);
            }
        }
        finalSearchAdapter.filteredlist(filterlist);
    }

    public void addData(String name, int img,String location){

        FinalSearchSuitcase finalSearchSuitcase = new FinalSearchSuitcase();
        finalSearchSuitcase.uname = name;
        finalSearchSuitcase.profileimg = img;
        finalSearchSuitcase.location = location;

        searchSuitcaseArrayList.add(finalSearchSuitcase);

    }

    private void initviews() {

        usersrecyclerview = findViewById(R.id.fs_recyclerview);
        edtsearch = findViewById(R.id.fs_edtsearch);
        materialToolbar = findViewById(R.id.fs_toolbar);

        filterimg = findViewById(R.id.fs_filterimg);
    }
}
