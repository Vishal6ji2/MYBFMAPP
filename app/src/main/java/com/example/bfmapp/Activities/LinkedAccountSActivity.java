package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class LinkedAccountSActivity extends AppCompatActivity {


    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_account_s);

        initviews();
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Linked Accounts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    private void initviews() {

        materialToolbar = findViewById(R.id.linkedas_toolbar);
    }
}
