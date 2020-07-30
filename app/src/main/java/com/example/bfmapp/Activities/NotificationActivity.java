package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.bfmapp.Adapters.NotiTabAdapter;
import com.example.bfmapp.Fragments.AllFragment;
import com.example.bfmapp.Fragments.ProposalFragment;
import com.example.bfmapp.Fragments.SentFragment;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabLayoutMediator tabLayoutMediator;

    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        prepareViewpager(viewPager2);

    }


    private void prepareViewpager(ViewPager2 viewPager2) {

        viewPager2.setAdapter(new NotiTabAdapter(this));

        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("All");
                        break;
                    case 1:
                        tab.setText("Proposal");
                        break;
                    case 2:
                        tab.setText("Sent");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

    }

    private void initviews() {

        tabLayout = findViewById(R.id.noti_tablayout);

        materialToolbar = findViewById(R.id.noti_toolbar);

        viewPager2 = findViewById(R.id.noti_viewpager2);

    }
}
