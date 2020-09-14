package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class RequestVerificationSActivity extends AppCompatActivity {

    Spinner spincategory;
    String selectcategory;

    MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_verification_s);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Request Verification");
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spinneritems();

        spincategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spincategory.getItemAtPosition(position).toString().equals("Category")){
                    selectcategory = "";

                }else {
                    selectcategory = spincategory.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(RequestVerificationSActivity.this, "Please Select your Category", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initviews() {

        spincategory = findViewById(R.id.reqveri_spinner);
        materialToolbar = findViewById(R.id.reqveri_toolbar);
    }


    private void spinneritems(){

        ArrayList<String> categories = new ArrayList<>();
        categories.add(0,"Category");
        categories.add("Director");
        categories.add("FilmMaker");
        categories.add("Photography");
        categories.add("VFX");
        categories.add("Animation");
        categories.add("Video Editing");
        categories.add("Vlogging");
        categories.add("CGI");
        categories.add("Blogging");
        categories.add("Science Fiction");
        categories.add("Illustrator");
        categories.add("3D Animation");
        categories.add("Novels");
        categories.add("Writing");
        categories.add("Script Writing");
        categories.add("2D Animation");
        categories.add("Content Writing");
        categories.add("Fiction");
        categories.add("Photoshop");
        categories.add("Others");

        ArrayAdapter<String > categoryadapter = new ArrayAdapter<>(RequestVerificationSActivity.this,android.R.layout.simple_list_item_1,categories);

        categoryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spincategory.setAdapter(categoryadapter);
    }
}
