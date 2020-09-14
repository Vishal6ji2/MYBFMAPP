package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ProposalsActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    CircularImageView userprofileimg;
    TextView txtusername,txtsubject,txtproposal,txttime;

    Intent intent;
    String username;
    int profileimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposals);

        initviews();


        intent = getIntent();
        if (intent != null){
            if (intent.getStringExtra("username") != null){
                username = intent.getStringExtra("username");
                profileimg = intent.getIntExtra("userprofileimg",R.drawable.ic_launcher_foreground);

                txtusername.setText(username);
                userprofileimg.setImageResource(profileimg);
            }
        }


        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Proposal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initviews() {

        materialToolbar = findViewById(R.id.prop_toolbar);

        userprofileimg = findViewById(R.id.prop_profileimg);

        txtusername = findViewById(R.id.prop_username);
        txtsubject = findViewById(R.id.prop_txtsubject);
        txtproposal = findViewById(R.id.prop_txtproposal);
        txttime = findViewById(R.id.prop_time);

    }
}
