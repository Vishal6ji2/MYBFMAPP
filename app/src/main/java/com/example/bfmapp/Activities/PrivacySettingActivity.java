package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.bfmapp.Fragments.BlockedAccountsFragment;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class PrivacySettingActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    FrameLayout fragcontainer;
    TextView txtblockedacc;

    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_setting);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Privacy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtblockedacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState!=null){
                    return;
                }
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.prisetting_fragcontainer,new BlockedAccountsFragment(),null);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void initviews() {

        fragmentManager = getSupportFragmentManager();

        txtblockedacc = findViewById(R.id.prisetting_txtblocked);

        fragcontainer = findViewById(R.id.prisetting_fragcontainer);

        materialToolbar = findViewById(R.id.prisetting_toolbar);
    }
}
