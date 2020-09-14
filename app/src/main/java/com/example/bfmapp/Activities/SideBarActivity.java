package com.example.bfmapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bfmapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;

public class SideBarActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView viewprofile,viewusername;
    LinearLayout llmyqr,viewsetting,viewlogout;
    CircularImageView viewprofileimg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidebarprofile);


        initviews();

        bottomNavigationView = findViewById(R.id.timeline_bnv);

        viewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,LoginActivity.class));

                finish();
            }
        });

        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,UserProfileActivity.class));


            }
        });

        viewusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,UserProfileActivity.class));


            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,UserProfileActivity.class));
            }
        });

        viewsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,SettingsActivity.class));
            }
        });

        llmyqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SideBarActivity.this,YourQrCodeActivity.class));
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.bnav_sidebar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bnav_noti){
                    startActivity(new Intent(SideBarActivity.this,NotificationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_home){
                    startActivity(new Intent(SideBarActivity.this,TimelinepostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_browser){
                    startActivity(new Intent(SideBarActivity.this,ExploreActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_add){
                    startActivity(new Intent(SideBarActivity.this,CreatePostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_sidebar){
                    return true;
                }

                return true;
            }
        });

    }

    private void initviews() {

        viewprofile = findViewById(R.id.sidebar_viewprofile);
        viewusername = findViewById(R.id.sidebar_username);
        viewsetting = findViewById(R.id.sidebar_setting);
        viewprofileimg = findViewById(R.id.sidebar_profileimg);
        viewlogout = findViewById(R.id.sidebar_logout);


        llmyqr = findViewById(R.id.sidebar_llmyqr);
    }
}
