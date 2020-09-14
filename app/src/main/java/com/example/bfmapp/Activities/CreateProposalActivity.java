package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;

public class CreateProposalActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    CircularImageView profileimg;
    TextView txtusername;
    EditText edtsubject,edtwritepropsal;

    Intent intent;

    String propname;
    int propprofileimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_proposal);

        initviews();


        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Create Proposal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        intent = getIntent();
        if (intent != null){

            if (intent.getStringExtra("propname") != null) {
                propname = intent.getStringExtra("propname");
                propprofileimg = intent.getIntExtra("propprofileimg", R.drawable.ic_launcher_foreground);

                profileimg.setImageResource(propprofileimg);
                txtusername.setText(propname);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.propsalmenus,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.propmenu_send){

            if (edtsubject.getText().toString().equals("")){
                Toast.makeText(this, "Please fill the Subject", Toast.LENGTH_SHORT).show();
            }else if (edtwritepropsal.getText().toString().equals("")){
                Toast.makeText(this, "Please write a Proposal ", Toast.LENGTH_SHORT).show();
            }else {
                edtsubject.setText("");
                edtwritepropsal.setText("");
                Toast.makeText(this, "Send Successfully", Toast.LENGTH_SHORT).show();
            }
        }

        return true;
    }

    private void initviews() {

        materialToolbar = findViewById(R.id.cprop_toolbar);
        profileimg = findViewById(R.id.cprop_profileimg);
        txtusername = findViewById(R.id.cprop_txtusername);
        edtsubject = findViewById(R.id.cprop_edtsubject);
        edtwritepropsal = findViewById(R.id.cprop_edtwriteproposal);
    }
}
