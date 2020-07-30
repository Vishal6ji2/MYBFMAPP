package com.example.bfmapp.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.io.IOException;

public class CreatePostActivity extends AppCompatActivity {

    TextView posttxt;

    MaterialToolbar materialToolbar;

    LinearLayout  llcamera,llgalleryvideo;

    ImageView postimg;

    EditText edtcaption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        initViews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setTitle("Create post");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        llgalleryvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
//                photoPickerIntent.putExtra(Intent.EXTRA_MIME_TYPES, new String[] {"image/*", "video/*"});
                startActivityForResult(photoPickerIntent, 200);    }
        });

        llcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);

            }
        });


        posttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CreatePostActivity.this, "Post work in process (Need server)", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initViews() {

        posttxt = findViewById(R.id.cp_posttxt);
        llcamera = findViewById(R.id.cp_llcamera);
        llgalleryvideo = findViewById(R.id.cp_llgalleryvideo);

        postimg = findViewById(R.id.cp_postimg);

        edtcaption = findViewById(R.id.cp_edtcaptain);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null){
            postimg.setVisibility(View.VISIBLE);

            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            postimg.setImageBitmap(bitmap);

        }else if (requestCode == 200 && resultCode == RESULT_OK && data != null){
            postimg.setVisibility(View.VISIBLE);
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                postimg.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
