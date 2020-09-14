package com.example.bfmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.Activities.ChatMessagesActivity;
import com.example.bfmapp.Activities.CreateProposalActivity;
import com.example.bfmapp.Activities.UserProfileActivity;
import com.example.bfmapp.Adapters.UserProfilePostsAdapter;
import com.example.bfmapp.Suitcases.UserPosts;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
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

    LinearLayout llmoreinfo;

    Intent intent;

    CircularImageView profileimg;

    TextView username,txtmore;

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


        addData(R.drawable.postone,likeduserimg,likedname,"5d","Jerky,London","Very cool day","31 likes","22 comments");
        addData(R.drawable.posttwo,likeduserimg,likedname,"6d","Chimjan,USA","Very cool day","12 likes","20 comments");
        addData(R.drawable.postthree,likeduserimg,likedname,"2w","Buddhapaste,London","Very cool day","81 likes","33 comments");
        addData(R.drawable.postfour,likeduserimg,likedname,"8w","Nadbai,Bharatpur","Very cool day","101 likes","10 comments");
        addData(R.drawable.postfive,likeduserimg,likedname,"10w","Somni,California","Very cool day","5 likes","2 comments");

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

        txtmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llmoreinfo.setVisibility(View.VISIBLE);
                userpostRecyclerview.setVisibility(View.INVISIBLE);
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


    private void initviews() {

        llmoreinfo = findViewById(R.id.otherup_llmoreinfo);

        txtmore = findViewById(R.id.otherup_txtmoreinfo);

        btnfollow = findViewById(R.id.otherup_btnfollow);
        btnmsg = findViewById(R.id.otherup_btnmsg);

        profileimg = findViewById(R.id.otherup_profileimg);

        username = findViewById(R.id.otherup_username);
        materialToolbar = findViewById(R.id.otherup_toolbar);
        gridviewimg = findViewById(R.id.otherup_gridimg);
        listviewimg = findViewById(R.id.otherup_listimg);

        userpostRecyclerview = findViewById(R.id.otherup_recyclerview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.userprofilemenus,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.otherup_menu){

            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OtherUsersProfileActivity.this);

            LinearLayout oupbslinearlayout = findViewById(R.id.oupbs_linearlayout);

            View bottomsheetview = LayoutInflater.from(this).inflate(R.layout.otherupbottomsheet,oupbslinearlayout);

            bottomsheetview.findViewById(R.id.oupbs_llblock).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OtherUsersProfileActivity.this, "User Blocked", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            bottomsheetview.findViewById(R.id.oupbs_llreport).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OtherUsersProfileActivity.this, "User reported", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            bottomsheetview.findViewById(R.id.oupbs_llsendprop).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OtherUsersProfileActivity.this, "Proposal sent", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(OtherUsersProfileActivity.this, CreateProposalActivity.class).putExtra("propname",likedname).putExtra("propprofileimg",likeduserimg));
                    bottomSheetDialog.dismiss();
                }
            });

            bottomsheetview.findViewById(R.id.oupbs_llshare).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(OtherUsersProfileActivity.this, "Share profile using.....", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            bottomSheetDialog.setContentView(bottomsheetview);
            bottomSheetDialog.show();


        }

        return true;
    }
}
