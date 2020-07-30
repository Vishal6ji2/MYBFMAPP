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
import android.widget.Toast;

import com.example.bfmapp.Adapters.ChatUsersAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ChatUsersSuitcase;
import com.google.android.material.appbar.MaterialToolbar;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class ChatUsersActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView curecyclerview;

    ArrayList<ChatUsersSuitcase> usersSuitcaseArrayList = new ArrayList<>();

    ChatUsersAdapter chatUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_users);

        initviews();

        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("Chat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        initRecyclerview();

    }

    private void initRecyclerview() {

        addData(R.drawable.profileone, "Mia Shroff", "I hope you find the best line", "2m");
        addData(R.drawable.profiletwo, "Alisa Katshow", "Best of luck", "1h");
        addData(R.drawable.profilethree, "Photographer freek", "There was time when i was use to what you know...", "2d");
        addData(R.drawable.profilefour, "ElinaFonser", "I hope you find the best line", "4d");
        addData(R.drawable.profilefive, "James Cameron", "Let's do it", "1w");


        chatUsersAdapter = new ChatUsersAdapter(this, usersSuitcaseArrayList);

        curecyclerview.setNestedScrollingEnabled(false);
        curecyclerview.setLayoutManager(new LinearLayoutManager(ChatUsersActivity.this));
        curecyclerview.setHasFixedSize(true);
        curecyclerview.setAdapter(chatUsersAdapter);

    }

    public void addData(int profileimg, String chattername, String lastmsg, String time) {

        ChatUsersSuitcase chatUsersSuitcase = new ChatUsersSuitcase();
        chatUsersSuitcase.chattername = chattername;
        chatUsersSuitcase.chatuserprofileimg = profileimg;
        chatUsersSuitcase.lastmsg = lastmsg;
        chatUsersSuitcase.time = time;

        usersSuitcaseArrayList.add(chatUsersSuitcase);
    }

    private void initviews() {

        toolbar = findViewById(R.id.cu_toolbar);

        curecyclerview = findViewById(R.id.cu_recyclerview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chatusersmenu, menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chatmenu_chat){
            startActivity(new Intent(ChatUsersActivity.this,NewChatActivity.class));

        }else if (item.getItemId() == R.id.chatmenu_search) {
            
            SearchView searchView = (SearchView) item.getActionView();

            searchView.setQueryHint("search here...");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    chatUsersAdapter.getFilter().filter(newText);


                    return true;
                }
            });


            Toast.makeText(this, "Search Click work in Progress", Toast.LENGTH_SHORT).show();



        }
        return true;
    }
}
