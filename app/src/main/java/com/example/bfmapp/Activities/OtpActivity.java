package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.example.bfmapp.CognitoSetting;
import com.example.bfmapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class OtpActivity extends AppCompatActivity {

    TextView txtmail,txtresendotp;
    TextInputEditText edtcode;
    Button btnnext;


    Intent intent;

    String username,emailid;
    CognitoSetting cognitoSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        initviews();

        intent = getIntent();
        if (intent!=null) {
            if (intent.getStringExtra("username") != null) {
                username = intent.getStringExtra("username");
                emailid = intent.getStringExtra("email");

                txtmail.setText(emailid);

                btnnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new ConfirmTask().execute(edtcode.getText().toString(),username);
                    }
                });

            }
        }

        txtresendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CognitoUser user = cognitoSetting.getuserpool().getUser(username);

                new ResendConfirmationCodeAsyncTask().execute(user);
            }
        });
    }

    private class ResendConfirmationCodeAsyncTask extends AsyncTask<CognitoUser,Void,String> {

        @Override
        protected String doInBackground(CognitoUser... cognitoUsers) {

            final String[] result = new String[1];

            VerificationHandler resendcodeconfirmhandler = new VerificationHandler() {
                @Override
                public void onSuccess(CognitoUserCodeDeliveryDetails verificationCodeDeliveryMedium) {
                    result[0] = "Confirmation code was successfully sent to :" + verificationCodeDeliveryMedium.getDestination();

                    Toast.makeText(OtpActivity.this, "Code Resend Successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Exception exception) {
                    result[0] = exception.getLocalizedMessage();
                    Log.d("resendfailed", exception.toString());
                    Toast.makeText(OtpActivity.this, "Failed to resend code", Toast.LENGTH_SHORT).show();

                }
            };

            cognitoUsers[0].resendConfirmationCodeInBackground(resendcodeconfirmhandler);

            return result[0];

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("verificationcode", s);
        }
    }

    private class ConfirmTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            final String[] result = new String[1];

            GenericHandler confirmationcallback = new GenericHandler() {
                @Override
                public void onSuccess() {
                    result[0] = "Succeeded";

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OtpActivity.this, "Sign up Successfully", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                @Override
                public void onFailure(Exception exception) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(OtpActivity.this, "Incorrect otp", Toast.LENGTH_SHORT).show();
                        }
                    });

                    result[0] = "Failed"+exception.getMessage();
                }
            };

            CognitoUser cognitoUser = cognitoSetting.getuserpool().getUser(strings[1]);
            cognitoUser.confirmSignUp(strings[0],false,confirmationcallback);
            return result[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("TAG","Confirmation result:"+s);
            if (s.contains("Failed")){
                Toast.makeText(OtpActivity.this, "Wrong otp entered", Toast.LENGTH_SHORT).show();
            }else {

                Toast.makeText(OtpActivity.this, "Verified successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(OtpActivity.this, AddInfoActivity.class));

            }
        }
    }

    private void initviews() {

        cognitoSetting = new CognitoSetting(OtpActivity.this);

        txtmail = findViewById(R.id.otp_txtmail);
        txtresendotp = findViewById(R.id.otp_txtresendotp);

        edtcode = findViewById(R.id.otp_edtcode);

        btnnext = findViewById(R.id.otp_btnnext);
    }
}
