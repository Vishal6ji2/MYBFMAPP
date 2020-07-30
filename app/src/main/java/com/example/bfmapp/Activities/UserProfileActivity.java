package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bfmapp.Adapters.UserProfilePostsAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.UserPosts;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

import static com.example.bfmapp.Adapters.UserProfilePostsAdapter.SPAN_COUNT_ONE;
import static com.example.bfmapp.Adapters.UserProfilePostsAdapter.SPAN_COUNT_THREE;

public class UserProfileActivity extends AppCompatActivity {


    RecyclerView userpostRecyclerview;

    ImageView gridviewimg,listviewimg;

    CardView editimg;

    ArrayList<UserPosts> postsArrayList = new ArrayList<>();

    GridLayoutManager gridLayoutManager;

    MaterialToolbar materialToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addData(R.drawable.profileone);
        addData(R.drawable.profiletwo);
        addData(R.drawable.postthree);
        addData(R.drawable.postfive);
        addData(R.drawable.postfour);
        addData(R.drawable.profileone);
        addData(R.drawable.profiletwo);
        addData(R.drawable.postthree);
        addData(R.drawable.postfive);
        addData(R.drawable.postfour);


        gridLayoutManager = new GridLayoutManager(UserProfileActivity.this,SPAN_COUNT_THREE);

        userpostRecyclerview.setLayoutManager(gridLayoutManager);
        userpostRecyclerview.setAdapter(new UserProfilePostsAdapter(this,postsArrayList,gridLayoutManager));


        editimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this,EditUserProfileActivity.class));
            }
        });

        gridviewimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
            }
        });

        listviewimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);

            }
        });

    }

    private void initviews() {

        materialToolbar = findViewById(R.id.userprofile_toolbar);
        gridviewimg = findViewById(R.id.userprofile_gridimg);
        listviewimg = findViewById(R.id.userprofile_listimg);

        editimg = findViewById(R.id.userprofile_edit);

        userpostRecyclerview = findViewById(R.id.userprofile_recyclerview);

    }

    public void addData(int imgs){

        UserPosts userPosts = new UserPosts();
        userPosts.userpostimg = imgs;

        postsArrayList.add(userPosts);
    }
}
