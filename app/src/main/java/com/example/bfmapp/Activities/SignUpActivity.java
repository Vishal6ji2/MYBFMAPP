package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText edtemail,edtmob,edtpass;
    TextView txtsignin;
    CheckBox rememberme;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initviews();

        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtemail.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this, "Please enter your Email id", Toast.LENGTH_SHORT).show();
                }else if (edtmob.getText().toString().length() < 10 && edtmob.getText().toString().length() > 10){
                    Toast.makeText(SignUpActivity.this, "Please enter your Mobile no.", Toast.LENGTH_SHORT).show();
                }else if (edtpass.getText().toString().equals("")){
                    Toast.makeText(SignUpActivity.this, "Please enter a strong password", Toast.LENGTH_SHORT).show();
                }else {

                    if (rememberme.isChecked()){
                        Toast.makeText(SignUpActivity.this, "Save Id Password", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(SignUpActivity.this, "Sign up Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this,AddInfoActivity.class));
                }
            }
        });
    }

    private void initviews() {
        edtemail = findViewById(R.id.signup_edtemail);
        edtmob = findViewById(R.id.signup_edtmob);
        edtpass = findViewById(R.id.signup_edtpass);

        txtsignin = findViewById(R.id.signup_txtsignin);

        rememberme = findViewById(R.id.signup_rememberme);

        btnsignup = findViewById(R.id.signup_btnsignup);
    }
}
