package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bfmapp.Adapters.LikedUsersAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.LikedUsers;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class LikesActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    TextView txtlikes;

    RecyclerView likedusersrecyclerview;

    ArrayList<LikedUsers> likedUsersArrayList = new ArrayList<>();

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Likes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addData("Mia shroff",R.drawable.profileone);
        addData("Alisa katshow",R.drawable.profiletwo);
        addData("Photographer.freak",R.drawable.profilethree);
        addData("Elina fonser",R.drawable.profilefour);
        addData("Alisa katshow",R.drawable.profilefive);
        addData("James cameron",R.drawable.profileone);
        addData("Mia shroff",R.drawable.profiletwo);
        addData("Racia",R.drawable.profilethree);
        addData("Jackquline fernandez",R.drawable.profilefour);
        addData("Shakira shakira",R.drawable.profilefive);


        likedusersrecyclerview.setHasFixedSize(true);
        likedusersrecyclerview.setNestedScrollingEnabled(false);
        likedusersrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        likedusersrecyclerview.setAdapter(new LikedUsersAdapter(this,likedUsersArrayList));

    }

    private void addData(String username, int profileimg) {

        LikedUsers likedUsers = new LikedUsers();
        likedUsers.likedusername = username;
        likedUsers.likedprofileimg = profileimg;

        likedUsersArrayList.add(likedUsers);
    }

    private void initviews() {

        materialToolbar = findViewById(R.id.likes_toolbar);
        txtlikes = findViewById(R.id.likes_txtlikes);
        likedusersrecyclerview = findViewById(R.id.likes_recyclerview);

    }
}
