package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.bfmapp.Adapters.AutoPlaceSuggestAdapter;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class FilterArtistActivity extends AppCompatActivity {

    ScrollView followersscrollview,categoriesscrollview;

    MaterialToolbar toolbar;

    LinearLayout categorieslayout,followerslayout;

    TextView txtapply,txtcancel,txtfollowers,txtcategories,txtlocation;

    AppCompatCheckBox appCompatCheckBox;

    AutoCompleteTextView autoplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_artist);

        initviews();


        txtcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(FilterArtistActivity.this,FinalSearchActivity.class));
                finish();
            }
        });

//        autoplace.setAdapter(new AutoPlaceSuggestAdapter(this,android.R.layout.simple_list_item_1));

        firstvisibility();

        txtfollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autoplace.setVisibility(View.GONE);
                categorieslayout.setVisibility(View.GONE);
                categoriesscrollview.setVisibility(View.GONE);
                followersscrollview.setVisibility(View.VISIBLE);
                followerslayout.setVisibility(View.VISIBLE);

                txtfollowers.setBackgroundColor(getResources().getColor(R.color.whitecolor));
                txtcategories.setBackgroundColor(getResources().getColor(R.color.greycolor));
                txtlocation.setBackgroundColor(getResources().getColor(R.color.greycolor));
            }
        });


        txtcategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autoplace.setVisibility(View.GONE);
                categorieslayout.setVisibility(View.VISIBLE);
                categoriesscrollview.setVisibility(View.VISIBLE);
                followersscrollview.setVisibility(View.GONE);
                followerslayout.setVisibility(View.GONE);
                txtfollowers.setBackgroundColor(getResources().getColor(R.color.greycolor));
                txtlocation.setBackgroundColor(getResources().getColor(R.color.greycolor));
                txtcategories.setBackgroundColor(getResources().getColor(R.color.whitecolor));
            }
        });

        txtlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autoplace.setVisibility(View.VISIBLE);
                categorieslayout.setVisibility(View.GONE);
                categoriesscrollview.setVisibility(View.GONE);
                followersscrollview.setVisibility(View.GONE);
                followerslayout.setVisibility(View.GONE);

                txtcategories.setBackgroundColor(getResources().getColor(R.color.greycolor));
                txtfollowers.setBackgroundColor(getResources().getColor(R.color.greycolor));
                txtlocation.setBackgroundColor(getResources().getColor(R.color.whitecolor));
            }
        });
    }

    private void firstvisibility() {

        autoplace.setVisibility(View.GONE);
        categorieslayout.setVisibility(View.VISIBLE);
        categoriesscrollview.setVisibility(View.VISIBLE);
        followersscrollview.setVisibility(View.GONE);
        followerslayout.setVisibility(View.GONE);
        txtfollowers.setBackgroundColor(getResources().getColor(R.color.greycolor));
        txtcategories.setBackgroundColor(getResources().getColor(R.color.whitecolor));
        txtlocation.setBackgroundColor(getResources().getColor(R.color.greycolor));

    }


    private void initviews() {

        toolbar = findViewById(R.id.filart_toolbar);

        autoplace = findViewById(R.id.filart_autoplace);

        categoriesscrollview = findViewById(R.id.filart_categoriesscrollview);
        followersscrollview = findViewById(R.id.filart_followersscrollview);

        categorieslayout = findViewById(R.id.filart_categorieslayout);
        followerslayout = findViewById(R.id.filart_followerslayout);

        txtapply = findViewById(R.id.filart_txtapply);
        txtcancel = findViewById(R.id.filart_txtcancel);

        txtlocation = findViewById(R.id.filart_txtlocation);
        txtfollowers = findViewById(R.id.filart_txtfollowers);
        txtcategories = findViewById(R.id.filart_txtcategories);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Filters");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
