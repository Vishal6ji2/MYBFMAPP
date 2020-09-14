package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.example.bfmapp.CognitoSetting;
import com.example.bfmapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtusername,edtpassword;
    TextView txtforgotpwd,txtsignup;
    Button btnlogin;


    CognitoSetting cognitoSetting;

    ForgotPasswordContinuation forgotPasswordContinuation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();


        final GetDetailsHandler getDetailsHandler = new GetDetailsHandler() {
            @Override
            public void onSuccess(CognitoUserDetails cognitoUserDetails) {

                Map<String,String> data =  cognitoUserDetails.getAttributes().getAttributes();

                String email = data.get("email");
                String username = data.get("preferred_username");
                String mobileno = data.get("phone_number");

                Log.d("emailid",email+","+username+","+mobileno);
            }

            @Override
            public void onFailure(Exception exception) {

                Toast.makeText(LoginActivity.this, "NO user found", Toast.LENGTH_SHORT).show();
                Log.d("nouser",exception.toString());
            }
        };

      /*  if (cognitoSetting.getuserpool().getCurrentUser() != null){
            CognitoUser cognitoUser = cognitoSetting.getuserpool().getCurrentUser();
            cognitoUser.getDetailsInBackground(getDetailsHandler);
            Toast.makeText(this, "User :"+cognitoSetting.getuserpool().getCurrentUser(), Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "null"+cognitoSetting.getuserpool().getCurrentUser(), Toast.LENGTH_SHORT).show();
        }
*/
        final ForgotPasswordHandler forgotPasswordHandler = new ForgotPasswordHandler() {
            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void getResetCode(ForgotPasswordContinuation continuation) {

                CognitoUserCodeDeliveryDetails codeDeliveryDetails = continuation.getParameters();
                Log.d("codesent",codeDeliveryDetails.getDestination());

                forgotPasswordContinuation = continuation;
            }

            @Override
            public void onFailure(Exception exception) {

                Log.d("failedcode",exception.toString());
                Toast.makeText(LoginActivity.this, "Code send failed!", Toast.LENGTH_SHORT).show();
            }
        };

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

        final AuthenticationHandler authenticationHandler = new AuthenticationHandler() {
            @Override
            public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                String json = gson.toJson(userSession);

                Log.d("username", userSession.getUsername());

                Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();


                Log.d("Usersession",json);

            }



            @Override
            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String userId) {

                AuthenticationDetails authenticationDetails = new AuthenticationDetails(userId,edtpassword.getText().toString(),null);

                authenticationContinuation.setAuthenticationDetails(authenticationDetails);

                authenticationContinuation.continueTask();

            }

            @Override
            public void getMFACode(MultiFactorAuthenticationContinuation continuation) {

            }

            @Override
            public void authenticationChallenge(ChallengeContinuation continuation) {

            }

            @Override
            public void onFailure(Exception exception) {

                Log.d("loginfailed",exception.toString());

                Toast.makeText(LoginActivity.this,"Incorrect username or password",Toast.LENGTH_SHORT).show();

            }
        };

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtusername.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter correct Username", Toast.LENGTH_SHORT).show();
                }else if (edtpassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter a correct Password", Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(LoginActivity.this, "Login work in progress", Toast.LENGTH_SHORT).show();

//                    CognitoUser cognitoUser = cognitoSetting.getuserpool().getUser(edtusername.getText().toString());

                    startActivity(new Intent(LoginActivity.this, TimelinepostActivity.class));
//                    cognitoUser.getSessionInBackground(authenticationHandler);


//                    showNotification();
                }
            }
        });


    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        if (cognitoSetting.getuserpool().getCurrentUser() != null) {

            startActivity(new Intent(LoginActivity.this, TimelinepostActivity.class));
            finish();
        }
    }*/

    private void showNotification() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("n","n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this,"n")
                .setContentText("You are successfully logged in")
                .setSmallIcon(R.drawable.toplogo)
                .setAutoCancel(true)
                .setContentTitle("BFM App");


        Intent intent = new Intent(LoginActivity.this,TimelinepostActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingIntent = PendingIntent.getActivity(LoginActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        notificationManagerCompat.notify(999,builder.build());
    }

    private void initViews() {

        cognitoSetting = new CognitoSetting(LoginActivity.this);

        edtusername = findViewById(R.id.login_edtusername);
        edtpassword = findViewById(R.id.login_edtpassword);

        txtforgotpwd = findViewById(R.id.login_txtforgotpwd);
        txtsignup = findViewById(R.id.login_txtsignup);

        btnlogin = findViewById(R.id.login_btnlogin);
    }
}
