package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.bfmapp.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class SelectCategoryActivity extends AppCompatActivity {

    ChipGroup chipGroup;

    Button btnnext;

    ArrayList<String> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        initviews();


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

        addview(categories);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectCategoryActivity.this,TimelinepostActivity.class));
            }
        });
    }

    private void initviews() {

        btnnext = findViewById(R.id.select_btnnext);
        chipGroup = findViewById(R.id.categorieschip_group);
    }

    public void addview(ArrayList<String> arrayList){

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        for (String chipsname:arrayList){
            chipGroup.setLayoutMode(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
            Chip chip = (Chip)layoutInflater.inflate(R.layout.categoriesitem,null,false);

            chip.setText(chipsname);
            chipGroup.addView(chip);
        }
    }
}
