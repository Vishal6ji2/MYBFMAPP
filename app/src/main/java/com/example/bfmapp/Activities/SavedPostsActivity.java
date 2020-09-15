package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.bfmapp.Adapters.TimelinePostAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.PostSuitcase;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class SavedPostsActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    RecyclerView savedrecyclerview;

    ArrayList<PostSuitcase> postSuitcaseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_posts);

        initviews();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Saved");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addPosts("Seronmeza","50 likes","54 comments","Jodhpur,Rajasthan","54 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically.",R.drawable.postone,R.drawable.profileone);

        addPosts("Vishal Kumavat","100 likes","102 comments","Jaipur,Rajasthan","12 minutes ago","This is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazing",R.drawable.posttwo,R.drawable.profiletwo);

        addPosts("Jackquline ","71 likes","77 comments","Pune,Maharastra","2 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically.",R.drawable.postthree,R.drawable.profilethree);

        addPosts("Tarun Kumar","68 likes","27 comments","Surat,Gujrat","44 minutes ago","Looking pretty and very awesomeness weather with wonderful feeling.",R.drawable.postfour,R.drawable.profilefour);

        addPosts("Kotlin watson","22 likes","212 comments","Chandni chowk,Delhi","5 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically." +
                "The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically." ,R.drawable.postfive,R.drawable.profilefive);




        savedrecyclerview.setHasFixedSize(true);
        savedrecyclerview.setNestedScrollingEnabled(false);
        savedrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        savedrecyclerview.setAdapter(new TimelinePostAdapter(this,postSuitcaseArrayList));




    }

    private void addPosts(String name,String likes,String comments, String location, String time,String captain, int postimg, int profileimg) {
        PostSuitcase postSuitcase = new PostSuitcase();

        postSuitcase.ps_name = name;
        postSuitcase.ps_likes = likes;
        postSuitcase.ps_comments = comments;
        postSuitcase.ps_captain = captain;
        postSuitcase.ps_location = location;
        postSuitcase.ps_time = time;
        postSuitcase.ps_imgpost = postimg;
        postSuitcase.ps_imgprofile = profileimg;

        postSuitcaseArrayList.add(postSuitcase);
    }


    private void initviews() {

        toolbar = findViewById(R.id.saved_toolbar);

        savedrecyclerview = findViewById(R.id.saved_recyclerview);
    }
}
