package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bfmapp.Adapters.NewChatsAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class NewChatActivity extends AppCompatActivity {

    RecyclerView newchatrecyclerview;

    MaterialToolbar materialToolbar;

    LinearLayout createlayout;

    ArrayList<NewChatsSuitcase> newChatsSuitcaseArrayList = new ArrayList<>();

    NewChatsAdapter chatsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_chat);

        initviews();


        setSupportActionBar(materialToolbar);

        getSupportActionBar().setTitle("New Message");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addData("Mia Shroff",R.drawable.profileone);
        addData("Alisa Katshow",R.drawable.profiletwo);
        addData("Photographer.freak",R.drawable.profilethree);
        addData("Elina Fonser",R.drawable.profilefour);
        addData("Alina kat",R.drawable.profilefive);
        addData("James cameron",R.drawable.profileone);
        addData("Jackquline",R.drawable.profiletwo);


        chatsAdapter = new NewChatsAdapter(this,newChatsSuitcaseArrayList);

        newchatrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        newchatrecyclerview.setAdapter(chatsAdapter);
        newchatrecyclerview.setHasFixedSize(true);
        newchatrecyclerview.setNestedScrollingEnabled(false);


        createlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewChatActivity.this,SelectGroupUsersActivity.class));
            }
        });

    }


    public void addData(String name,int profileimg){
        NewChatsSuitcase newChatsSuitcase = new NewChatsSuitcase();

        newChatsSuitcase.newchatname = name;
        newChatsSuitcase.newchatimg = profileimg;

        newChatsSuitcaseArrayList.add(newChatsSuitcase);
    }

    private void initviews() {

        createlayout = findViewById(R.id.nc_createlayout);

        materialToolbar = findViewById(R.id.nc_toolbar);

        newchatrecyclerview = findViewById(R.id.nc_usersrecyclerview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.newchatmenu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nc_searchmenu){

                SearchView searchView = (SearchView) item.getActionView();

                searchView.setQueryHint("search here...");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        chatsAdapter.getFilter().filter(newText);
                        return false;
                    }
                });
            Toast.makeText(this, "Work in Process", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
