package com.example.bfmapp;

import android.content.Context;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

public class CognitoSetting {

    String userpoolid = "ap-south-1_SNRaxwx0Z";

    String appclientid = "2orb7i3ifp3lop0mon99vo731d";

    String appclientsecret = "1qukr8ssm5vsq1jsk6si6rc1ie65q4sj9tdtu0np9fkfedqui8vf";

    Regions cognitoregion = Regions.AP_SOUTH_1;

    Context context;

    public CognitoSetting(Context context){
        this.context = context;
    }


    public CognitoUserPool  getuserpool(){
        return new CognitoUserPool(context,userpoolid,appclientid,appclientsecret,cognitoregion);
    }
}
