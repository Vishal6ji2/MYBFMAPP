package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtusername,edtpassword;
    TextView txtforgotpwd,txtsignup;
    Button btnlogin;
//    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();


        txtforgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, " Forgot password Work in Progress......", Toast.LENGTH_SHORT).show();
            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                finish();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtusername.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter correct Username", Toast.LENGTH_SHORT).show();
                }else if (edtpassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter a correct Password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Login work in progress", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,TimelinepostActivity.class));
                }
            }
        });
    }

    private void initViews() {

        edtusername = findViewById(R.id.login_edtusername);
        edtpassword = findViewById(R.id.login_edtpassword);

        txtforgotpwd = findViewById(R.id.login_txtforgotpwd);
        txtsignup = findViewById(R.id.login_txtsignup);

        btnlogin = findViewById(R.id.login_btnlogin);
    }
}
