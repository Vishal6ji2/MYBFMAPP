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
import android.widget.LinearLayout;
import android.widget.TextView;

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

    LinearLayout llmoreinfo;

    TextView txtmore;

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

        addData(R.drawable.postone,R.drawable.profilefive,"Alisa Coalson","5d","Jerky,London","Very cool day","31 likes","22 comments");
        addData(R.drawable.posttwo,R.drawable.profilefive,"Alisa Coalson","6d","Chimjan,USA","Very cool day","12 likes","20 comments");
        addData(R.drawable.postthree,R.drawable.profilefive,"Alisa Coalson","2w","Buddhapaste,London","Very cool day","81 likes","33 comments");
        addData(R.drawable.postfour,R.drawable.profilefive,"Alisa Coalson","8w","Nadbai,Bharatpur","Very cool day","101 likes","10 comments");
        addData(R.drawable.postfive,R.drawable.profilefive,"Alisa Coalson","10w","Somni,California","Very cool day","5 likes","2 comments");


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
                llmoreinfo.setVisibility(View.INVISIBLE);
                userpostRecyclerview.setVisibility(View.VISIBLE);
                gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
            }
        });

        listviewimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llmoreinfo.setVisibility(View.INVISIBLE);
                userpostRecyclerview.setVisibility(View.VISIBLE);
                gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);

            }
        });

        txtmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userpostRecyclerview.setVisibility(View.INVISIBLE);
                llmoreinfo.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initviews() {

        llmoreinfo = findViewById(R.id.userprofile_llmoreinfo);

        txtmore = findViewById(R.id.userprofile_txtmore);

        materialToolbar = findViewById(R.id.userprofile_toolbar);
        gridviewimg = findViewById(R.id.userprofile_gridimg);
        listviewimg = findViewById(R.id.userprofile_listimg);

        editimg = findViewById(R.id.userprofile_edit);

        userpostRecyclerview = findViewById(R.id.userprofile_recyclerview);

    }

    public void addData(int imgs,int profileimg,String username,String posttime,String postlocation,String postlines,String likes,String comments){

        UserPosts userPosts = new UserPosts();

        userPosts.userpostimg = imgs;
        userPosts.profileimg = profileimg;

        userPosts.username = username;
        userPosts.posttime = posttime;
        userPosts.postlocation = postlocation;
        userPosts.postlines = postlines;
        userPosts.likes = likes;
        userPosts.comments = comments;

        postsArrayList.add(userPosts);
    }
}
