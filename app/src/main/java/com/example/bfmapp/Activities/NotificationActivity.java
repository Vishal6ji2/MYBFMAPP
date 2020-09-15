package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bfmapp.Adapters.NotiTabAdapter;
import com.example.bfmapp.Fragments.AllFragment;
import com.example.bfmapp.Fragments.ProposalFragment;
import com.example.bfmapp.Fragments.SentFragment;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabLayoutMediator tabLayoutMediator;

    MaterialToolbar materialToolbar;

//    private SlidingRootNav slidingRootNav;

    DrawerLayout drawerLayout;

    BottomNavigationView bottomNavigationView;

    CardView carddrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        initviews();

        setSupportActionBar(materialToolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        prepareViewpager(viewPager2);

        bottomNavigationView.setSelectedItemId(R.id.bnav_noti);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bnav_home){
                    startActivity(new Intent(NotificationActivity.this,TimelinepostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_browser){
                    startActivity(new Intent(NotificationActivity.this,ExploreActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_noti){
                    return true;
                }else if (item.getItemId() == R.id.bnav_add){
                    startActivity(new Intent(NotificationActivity.this,CreatePostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }/*else if (item.getItemId() == R.id.bnav_sidebar){
                    startActivity(new Intent(NotificationActivity.this,SideBarActivity.class));
                    overridePendingTransition(0,0);
                }*/

                return true;
            }
        });

        /*slidingRootNav =  new SlidingRootNavBuilder(NotificationActivity.this)
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
                startActivity(new Intent(NotificationActivity.this,SavedPostsActivity.class));
            }
        });

        carddrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });


        myqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,YourQrCodeActivity.class));
                closeDrawer(drawerLayout);
            }
        });

        viewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,LoginActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
                finish();
            }
        });

        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);

            }
        });

        viewusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);

            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this,SettingsActivity.class));
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


    private void prepareViewpager(ViewPager2 viewPager2) {

        viewPager2.setAdapter(new NotiTabAdapter(this));

        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("All");
                        break;
                    case 1:
                        tab.setText("Proposal");
                        break;
                    case 2:
                        tab.setText("Sent");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

    }

    private void initviews() {



        carddrawer = findViewById(R.id.timeline_carddrawer);

        drawerLayout = findViewById(R.id.timeline_drawerlayout);

        bottomNavigationView = findViewById(R.id.timeline_bnv);

        tabLayout = findViewById(R.id.noti_tablayout);

        materialToolbar = findViewById(R.id.noti_toolbar);

        viewPager2 = findViewById(R.id.noti_viewpager2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.createproposalmenus,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.createprop_menu){
            startActivity(new Intent(NotificationActivity.this,CreateProposalActivity.class));
        }
        return true;
    }
}
