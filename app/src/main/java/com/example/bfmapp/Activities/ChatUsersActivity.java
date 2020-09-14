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

import java.util.ArrayList;

public class ChatUsersActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView curecyclerview;

   public static final ArrayList<ChatUsersSuitcase> usersSuitcaseArrayList = new ArrayList<>();

    ChatUsersAdapter chatUsersAdapter;

    public static boolean isinActionmode = false;
    public static ArrayList<ChatUsersSuitcase> selectedusersarraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_users);

        initviews();

        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("Chats");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        initRecyclerview();

    }

    public void prepareToolbar(int position){

//        chatUsersAdapter.flag = 1;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.chatuserscontextualmenus);
        isinActionmode = true;
        chatUsersAdapter.notifyDataSetChanged();

        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        prepareSelection(position);
    }

    public void prepareSelection(int position) {

        if (!selectedusersarraylist.contains(usersSuitcaseArrayList.get(position))){
            selectedusersarraylist.add(usersSuitcaseArrayList.get(position));
            chatUsersAdapter.notifyDataSetChanged();
        }else {
            selectedusersarraylist.remove(usersSuitcaseArrayList.get(position));
            chatUsersAdapter.notifyDataSetChanged();
        }

        updateViewcounter();
    }

    private void updateViewcounter() {
        chatUsersAdapter.notifyDataSetChanged();
        int counter = 0;
        counter = selectedusersarraylist.size();
        toolbar.setTitle(counter+" item(s) selected ");
        chatUsersAdapter.notifyDataSetChanged();
    }

    private void initRecyclerview() {

        usersSuitcaseArrayList.clear();
        selectedusersarraylist.clear();

        addData(R.drawable.profileone, "Mia Shroff", "I hope you find the best line", "2m");
        addData(R.drawable.profiletwo, "Alisa Katshow", "Best of luck", "1h");
        addData(R.drawable.profilethree, "Photographer freek", "There was time when i was use to what you know...", "2d");
        addData(R.drawable.profilefour, "ElinaFonser", "I hope you find the best line", "4d");
        addData(R.drawable.profilefive, "James Cameron", "Let's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do itLet's do it", "1w");


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
                    return false;
                }
            });
            Toast.makeText(this, "Search Click work in Progress", Toast.LENGTH_SHORT).show();

        }else if (item.getItemId() == R.id.chatmenu_delete){
            isinActionmode = false;
            chatUsersAdapter.removedata(selectedusersarraylist);
            clearActionMode();
            chatUsersAdapter.notifyDataSetChanged();
        }else if (item.getItemId() == R.id.chatmenu_selectall){
            selectedusersarraylist.clear();
            isinActionmode = true;

            selectedusersarraylist.addAll(usersSuitcaseArrayList);

            updateViewcounter();

        }else if (item.getItemId() == android.R.id.home){
            clearActionMode();
            chatUsersAdapter.notifyDataSetChanged();
        }
        return true;
    }

    public void clearActionMode() {
        ChatUsersAdapter.flag = 0;
        isinActionmode = false;
        toolbar.getMenu().clear();
        toolbar.inflateMenu(R.menu.chatusersmenu);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Chats");
        }
        selectedusersarraylist.clear();

    }


    @Override
    public void onBackPressed() {
        if (isinActionmode){
            clearActionMode();
            chatUsersAdapter.notifyDataSetChanged();
        }else {
            super.onBackPressed();
        }
    }
}
