package com.example.bfmapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PlaceSuggestApi {

    public ArrayList<String> autoComplete(String input){

        ArrayList<String> arrayList = new ArrayList();
        HttpURLConnection httpURLConnection = null;
        StringBuilder jsonResult = new StringBuilder();

        try {

        StringBuilder stringBuilder = new StringBuilder("api");
        stringBuilder.append("input="+input);
        stringBuilder.append("&key="+"apikey");

            URL url = new URL(stringBuilder.toString());
            httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

            int read;

            char[] buff = new char[1024];

            while ((read = inputStreamReader.read(buff))!=-1){
                jsonResult.append(buff,0,read);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonResult.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("predictions");
            for (int i = 0;i<jsonArray.length();i++){
                arrayList.add(jsonArray.getJSONObject(i).getString("description"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}
