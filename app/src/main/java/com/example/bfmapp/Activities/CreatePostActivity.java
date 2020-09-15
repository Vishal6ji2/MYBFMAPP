package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.scales.Linear;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.io.IOException;

public class CreatePostActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    TextView posttxt;

    MaterialToolbar materialToolbar;

    LinearLayout  llcamera,llgalleryvideo;

    ImageView postimg;

//    private SlidingRootNav slidingRootNav;

    EditText edtcaption;

    CardView carddrawer;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        initViews();

        setSupportActionBar(materialToolbar);

//        getSupportActionBar().setTitle("Create post");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView.setSelectedItemId(R.id.bnav_add);

//        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

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

        carddrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bnav_noti){

                    startActivity(new Intent(CreatePostActivity.this,NotificationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_browser){
                    startActivity(new Intent(CreatePostActivity.this,ExploreActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_home){
                    startActivity(new Intent(CreatePostActivity.this,TimelinepostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_add){
                    return true;
                }/*else if (item.getItemId() == R.id.bnav_sidebar){
                    startActivity(new Intent(CreatePostActivity.this,SideBarActivity.class));
                    overridePendingTransition(0,0);
                }*/

                return true;
            }
        });


/*
        slidingRootNav =  new SlidingRootNavBuilder(CreatePostActivity.this)
                .withToolbarMenuToggle(materialToolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.sidebarprofile)
                .inject();
*/

        TextView viewprofile = findViewById(R.id.sidebar_viewprofile);
        TextView viewusername = findViewById(R.id.sidebar_username);
        LinearLayout viewsetting = findViewById(R.id.sidebar_setting);
        CircularImageView viewprofileimg = findViewById(R.id.sidebar_profileimg);
        LinearLayout viewlogout = findViewById(R.id.sidebar_logout);
        LinearLayout myqr = findViewById(R.id.sidebar_llmyqr);

        LinearLayout llsaved = findViewById(R.id.sidebar_llsaved);


        llsaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,SavedPostsActivity.class));
            }
        });


        myqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,YourQrCodeActivity.class));
                closeDrawer(drawerLayout);
            }
        });


        viewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,LoginActivity.class));
//                slidingRootNav.closeMenu();
                finish();
                closeDrawer(drawerLayout);
            }
        });

        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatePostActivity.this,SettingsActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    private void initViews() {

        drawerLayout = findViewById(R.id.timeline_drawerlayout);

        carddrawer = findViewById(R.id.timeline_carddrawer);

        bottomNavigationView = findViewById(R.id.timeline_bnv);

        materialToolbar = findViewById(R.id.cp_toolbar);

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
