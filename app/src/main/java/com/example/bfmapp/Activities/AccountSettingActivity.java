package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class AccountSettingActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    TextView txtactivities,txtdetails,txthistory,txtlanguage,txtverification,txtlinked,txtdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtactivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountSettingActivity.this,YourActivitySettingActivity.class));
                overridePendingTransition(0,0);
            }
        });


        txtlinked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountSettingActivity.this,LinkedAccountSActivity.class));
                overridePendingTransition(0,0);
            }
        });

        txtdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountSettingActivity.this,DeleteAccountSettingActivity.class));
                overridePendingTransition(0,0);
            }
        });

        txtverification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountSettingActivity.this,RequestVerificationSActivity.class));
                overridePendingTransition(0,0);
            }
        });


    }

    private void initviews() {

        materialToolbar = findViewById(R.id.accounts_toolbar);

        txthistory = findViewById(R.id.accounts_txthistory);
        txtactivities = findViewById(R.id.accounts_txtactivities);
        txtdetails = findViewById(R.id.accounts_txtdetails);
        txtlanguage = findViewById(R.id.accounts_txtlanguage);
        txtverification = findViewById(R.id.accounts_txtverification);
        txtlinked = findViewById(R.id.accounts_txtlinked);
        txtdelete = findViewById(R.id.accounts_txtdelete);
    }
}
