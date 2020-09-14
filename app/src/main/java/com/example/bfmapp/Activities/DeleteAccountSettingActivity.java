package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class DeleteAccountSettingActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_setting);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Deactivate my account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initviews() {

        materialToolbar = findViewById(R.id.deleteas_toolbar);
    }
}
