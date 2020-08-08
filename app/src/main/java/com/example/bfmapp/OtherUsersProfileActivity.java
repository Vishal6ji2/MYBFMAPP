package com.example.bfmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bfmapp.Activities.ChatMessagesActivity;
import com.example.bfmapp.Activities.UserProfileActivity;
import com.example.bfmapp.Adapters.UserProfilePostsAdapter;
import com.example.bfmapp.Suitcases.UserPosts;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import static com.example.bfmapp.Adapters.UserProfilePostsAdapter.SPAN_COUNT_ONE;
import static com.example.bfmapp.Adapters.UserProfilePostsAdapter.SPAN_COUNT_THREE;

public class OtherUsersProfileActivity extends AppCompatActivity {

    MaterialButton btnfollow,btnmsg;

    RecyclerView userpostRecyclerview;

    ImageView gridviewimg,listviewimg;

    ArrayList<UserPosts> postsArrayList = new ArrayList<>();

    GridLayoutManager gridLayoutManager;

    MaterialToolbar materialToolbar;

    Intent intent;

    CircularImageView profileimg;

    TextView username;

    int likeduserimg;
    String likedname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_users_profile);

        initviews();


        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        intent = getIntent();
        if (intent != null){

            if (intent.getStringExtra("username") != null) {
                 likedname = intent.getStringExtra("username");
                 likeduserimg = intent.getIntExtra("userimg", R.drawable.ic_launcher_foreground);

                getSupportActionBar().setTitle(likedname);
                profileimg.setImageResource(likeduserimg);
                username.setText(likedname);
            }
        }


        addData(R.drawable.profileone);
        addData(R.drawable.profiletwo);
        addData(R.drawable.postthree);
        addData(R.drawable.postfive);
        addData(R.drawable.postfour);

        gridLayoutManager = new GridLayoutManager(OtherUsersProfileActivity.this,SPAN_COUNT_THREE);

        userpostRecyclerview.setLayoutManager(gridLayoutManager);
        userpostRecyclerview.setAdapter(new UserProfilePostsAdapter(this,postsArrayList,gridLayoutManager));


        btnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnfollow.getText().equals("Follow")){
                    btnfollow.setText("Following");
                    btnfollow.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    btnfollow.setBackgroundTintList(getResources().getColorStateList(android.R.color.white));

                }else {
                    btnfollow.setText("Follow");
                    btnfollow.setTextColor(getResources().getColor(R.color.whitecolor));
                    btnfollow.setBackgroundTintList(getResources().getColorStateList(R.color.bluecolor));

                }

            }
        });

        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OtherUsersProfileActivity.this, ChatMessagesActivity.class);
                intent.putExtra("chattername",likedname);
                intent.putExtra("chatterimg",likeduserimg);
                startActivity(intent);


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

    private void addData(int userpost) {

        UserPosts userPosts = new UserPosts();
        userPosts.userpostimg = userpost;

        postsArrayList.add(userPosts);

    }

    private void initviews() {

        btnfollow = findViewById(R.id.otherup_btnfollow);
        btnmsg = findViewById(R.id.otherup_btnmsg);

        profileimg = findViewById(R.id.otherup_profileimg);

        username = findViewById(R.id.otherup_username);
        materialToolbar = findViewById(R.id.otherup_toolbar);
        gridviewimg = findViewById(R.id.otherup_gridimg);
        listviewimg = findViewById(R.id.otherup_listimg);

        userpostRecyclerview = findViewById(R.id.otherup_recyclerview);

    }
}
