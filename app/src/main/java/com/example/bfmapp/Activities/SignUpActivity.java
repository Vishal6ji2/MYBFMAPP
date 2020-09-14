package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
import com.example.bfmapp.CognitoSetting;
import com.example.bfmapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText edtemail,edtmob,edtpass;
    TextView txtsignin;
    CheckBox rememberme;
    Button btnsignup;
    public static String tag = "tag";
    CognitoUserAttributes userAttributes;
    SignUpHandler signUpHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initviews();

        userAttributes = new CognitoUserAttributes();


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
//                    signup();

                    startActivity(new Intent(SignUpActivity.this,AddInfoActivity.class));
                    finish();
                }
            }
        });

//        signUpHandler = new SignUpHandler() {
//            @Override
//            public void onSuccess(CognitoUser user, boolean signUpConfirmationState, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
//
//                Log.d(tag, "success" + signUpConfirmationState);
//
//                if (!signUpConfirmationState) {
//                    Toast.makeText(SignUpActivity.this, "Code to be sent" + cognitoUserCodeDeliveryDetails.getDestination(), Toast.LENGTH_SHORT).show();
//                    Log.d(tag, "unsuccess" + signUpConfirmationState + cognitoUserCodeDeliveryDetails.getDestination());
//
//                } else {
//                    Log.d(tag, "success" + signUpConfirmationState);
//                    Toast.makeText(SignUpActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
//                }
//
//
//                startActivity(new Intent(SignUpActivity.this,OtpActivity.class)
//                .putExtra("username",edtpass.getText().toString())
//                .putExtra("email",edtemail.getText().toString()));
//                finish();
//            }
//
//            @Override
//            public void onFailure(Exception exception) {
//
//                Log.d(tag,exception.toString());
//                Toast.makeText(SignUpActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
//            }
//        };

    }

    public void signup(){

        long unixtime = System.currentTimeMillis()/1000L;

        userAttributes.addAttribute("email",edtemail.getText().toString());
        userAttributes.addAttribute("phone_number","+"+edtmob.getText().toString());

        userAttributes.addAttribute("address","empty");
        userAttributes.addAttribute("birthdate","10/08/2020");
        userAttributes.addAttribute("gender","empty");
        userAttributes.addAttribute("locale","empty");
        userAttributes.addAttribute("name","empty");
        userAttributes.addAttribute("picture","empty");
        userAttributes.addAttribute("preferred_username",edtpass.getText().toString());
        userAttributes.addAttribute("profile","empty");
        userAttributes.addAttribute("zoneinfo","empty");
        userAttributes.addAttribute("updated_at",String.valueOf(unixtime));
        userAttributes.addAttribute("website","empty");



        CognitoSetting cognitoSettings = new CognitoSetting(SignUpActivity.this);
        cognitoSettings.getuserpool().signUpInBackground(edtpass.getText().toString(),edtpass.getText().toString(),userAttributes,null,signUpHandler);

        CognitoUser cognitoUser = cognitoSettings.getuserpool().getUser(edtmob.getText().toString());

        UpdateAttributesHandler updateAttributesHandler = new UpdateAttributesHandler() {
            @Override
            public void onSuccess(List<CognitoUserCodeDeliveryDetails> attributesVerificationList) {

//                attributesVerificationList.

            }

            @Override
            public void onFailure(Exception exception) {

            }
        };

        cognitoUser.updateAttributesInBackground(userAttributes,updateAttributesHandler);

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


