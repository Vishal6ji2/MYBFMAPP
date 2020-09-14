package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;

public class SinglePostActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    CircularImageView profileimg;
    ImageView postimg;
    TextView txtname,txttime,txtlocation,txtlikes,txtcomments,txtpostlines;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post);

        initviews();


        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intent = getIntent();

        if (intent != null){
            if (intent.getStringExtra("username") != null){

                txtname.setText(intent.getStringExtra("username"));
                profileimg.setImageResource(intent.getIntExtra("userprofileimg",R.drawable.ic_launcher_foreground));
                txttime.setText(intent.getStringExtra("posttime"));
                txtlocation.setText(intent.getStringExtra("postlocation"));
                postimg.setImageResource(intent.getIntExtra("postimg",R.drawable.ic_launcher_foreground));
                txtpostlines.setText(intent.getStringExtra("postlines"));
                txtlikes.setText(intent.getStringExtra("postlikes"));
                txtcomments.setText(intent.getStringExtra("postcomments"));
            }
        }


    }

    private void initviews() {

        materialToolbar = findViewById(R.id.singlep_toolbar);

        profileimg = findViewById(R.id.singlep_imgprofile);
        postimg = findViewById(R.id.singlep_imgpost);

        txtname = findViewById(R.id.singlep_txtname);
        txttime = findViewById(R.id.singlep_txttime);
        txtlocation = findViewById(R.id.singlep_txtlocation);
        txtlikes = findViewById(R.id.singlep_txtlikes);
        txtcomments = findViewById(R.id.singlep_txtcomments);
        txtpostlines = findViewById(R.id.singlep_txtlines);

    }
}
