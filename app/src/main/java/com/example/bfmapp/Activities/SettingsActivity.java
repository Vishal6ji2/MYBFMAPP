package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class SettingsActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    EditText edtsearch;
    TextView txtaccount,txtsecurity,txtnotification,txtprivacy,txthelp,txtabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Settings");
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this,AccountSettingActivity.class));
            }
        });

        txtnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this,NotificationSettingActivity.class));
            }
        });


        txtabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this,AboutSettingActivity.class));
            }
        });

        txtprivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this,PrivacySettingActivity.class));
            }
        });


    }

    private void initviews() {

        materialToolbar = findViewById(R.id.setting_toolbar);

        edtsearch = findViewById(R.id.setting_edtsearch);
        txtaccount = findViewById(R.id.setting_txtaccount);
        txtsecurity = findViewById(R.id.setting_txtsecurity);
        txtnotification = findViewById(R.id.setting_txtnotification);
        txtprivacy = findViewById(R.id.setting_txtprivacy);
        txtabout = findViewById(R.id.setting_txtabout);
        txthelp = findViewById(R.id.setting_txthelp);
    }
}
