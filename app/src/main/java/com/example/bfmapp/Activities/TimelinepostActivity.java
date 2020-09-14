package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bfmapp.Adapters.DrawerAdapter;
import com.example.bfmapp.Adapters.TimelinePostAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.DrawerItem;
import com.example.bfmapp.Suitcases.PostSuitcase;
import com.example.bfmapp.Suitcases.SimplemenuItem;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class TimelinepostActivity extends AppCompatActivity /*implements DrawerAdapter.OnItemSelectedListener*/ {


    /*private static final int POS_SETTINGS = 0;
    private static final int POS_SAVED = 1;
    private static final int POS_FAQ = 2;
    private static final int POS_INVITEFRIENDS = 3;
    private static final int POS_LOGOUT = 5;

    private String[] screenTitles;
    private Drawable[] screenIcons;
*/
    private SlidingRootNav slidingRootNav;

    MaterialToolbar toolbar;

    ImageView imgsearch;
    TextView edtartist;
    CardView cardmsg;

    LinearLayout  searchbarlayout;
    RecyclerView timelinerecyclerview;

    BottomNavigationView bottomNavigationView;

    ArrayList<PostSuitcase> postSuitcaseArrayList = new ArrayList<>();
    ArrayList<PostSuitcase> suitcaseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timelinepost);


        initviews();

        setSupportActionBar(toolbar);

        bottomNavigationView.setSelectedItemId(R.id.bnav_home);

        searchbarlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });


        edtartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bnav_noti){

                    startActivity(new Intent(TimelinepostActivity.this,NotificationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_browser){
                    startActivity(new Intent(TimelinepostActivity.this,ExploreActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_home){
                    return true;
                }else if (item.getItemId() == R.id.bnav_add){
                    startActivity(new Intent(TimelinepostActivity.this,CreatePostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_sidebar){
                    startActivity(new Intent(TimelinepostActivity.this,SideBarActivity.class));
                    overridePendingTransition(0,0);
                }

                return true;
            }
        });

        cardmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,ChatUsersActivity.class));
            }
        });

      /* slidingRootNav =  new SlidingRootNavBuilder(TimelinepostActivity.this)
               .withToolbarMenuToggle(toolbar)
               .withMenuOpened(false)
               .withContentClickableWhenMenuOpened(false)
               .withSavedState(savedInstanceState)
               .withMenuLayout(R.layout.sidebarprofile)
               .inject();

       TextView viewprofile = findViewById(R.id.sidebar_viewprofile);
       TextView viewusername = findViewById(R.id.sidebar_username);
       LinearLayout viewsetting = findViewById(R.id.sidebar_setting);
       CircularImageView viewprofileimg = findViewById(R.id.sidebar_profileimg);
       LinearLayout viewlogout = findViewById(R.id.sidebar_logout);


       viewprofile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(TimelinepostActivity.this,UserProfileActivity.class));
               slidingRootNav.closeMenu();

           }
       });

        viewusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,UserProfileActivity.class));
                slidingRootNav.closeMenu();

            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,UserProfileActivity.class));
                slidingRootNav.closeMenu();

            }
        });

        viewsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,SettingsActivity.class));
                slidingRootNav.closeMenu();
            }
        });


        viewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimelinepostActivity.this,LoginActivity.class));
                slidingRootNav.closeMenu();
                finish();
            }
        });*/
//       screenIcons = loadScreeicons();
//       screenTitles = loadScreentitles();


    /*   DrawerAdapter drawerAdapter = new DrawerAdapter(Arrays.asList(
               createItemFor(POS_SETTINGS),
               createItemFor(POS_SAVED),
               createItemFor(POS_FAQ),
               createItemFor(POS_INVITEFRIENDS),
               createItemFor(POS_LOGOUT)));

       drawerAdapter.setListener(this);
*/




        addPosts("Seronmeza","50 likes","54 comments","Jodhpur,Rajasthan","54 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically.",R.drawable.postone,R.drawable.profileone);

        addPosts("Vishal Kumavat","100 likes","102 comments","Jaipur,Rajasthan","12 minutes ago","This is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazingThis is very good now i'm fine and it's very amazing",R.drawable.posttwo,R.drawable.profiletwo);

        addPosts("Jackquline ","71 likes","77 comments","Pune,Maharastra","2 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically.",R.drawable.postthree,R.drawable.profilethree);

        addPosts("Tarun Kumar","68 likes","27 comments","Surat,Gujrat","44 minutes ago","Looking pretty and very awesomeness weather with wonderful feeling.",R.drawable.postfour,R.drawable.profilefour);

        addPosts("Kotlin watson","22 likes","212 comments","Chandni chowk,Delhi","5 minutes ago","The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically." +
                "The are of showing the video cinematically.The are of showing the video cinematically.The are of showing the video cinematically." ,R.drawable.postfive,R.drawable.profilefive);


        for (int i = 0;i<10;i++){

            getRandomList(postSuitcaseArrayList);

        }

        timelinerecyclerview.setHasFixedSize(true);
        timelinerecyclerview.setNestedScrollingEnabled(false);
        timelinerecyclerview.setLayoutManager(new LinearLayoutManager(this));
        timelinerecyclerview.setAdapter(new TimelinePostAdapter(this,postSuitcaseArrayList));


    }
  /*  private DrawerItem createItemFor(int position) {
        return new SimplemenuItem(screenIcons[position], screenTitles[position])
                .withIconTint(R.color.colorAccent)
                .withTextTint((R.color.colorAccent))
                .withSelectedItemIconTint((R.color.colorAccent))
                .withSelectedTextTint((R.color.colorAccent));
    }
*/
  /*  private String[] loadScreentitles() {
        return getResources().getStringArray(R.array.sidebarmenunames);
    }

    private Drawable[] loadScreeicons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.sidebarmenuicons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }
*/
    private void getRandomList(ArrayList<PostSuitcase> arrayList) {

        Random random = new Random();

        int randomindex = random.nextInt(arrayList.size());

        PostSuitcase postSuitcase = new PostSuitcase();

        postSuitcase.ps_name = arrayList.get(randomindex).ps_name;
        postSuitcase.ps_time = arrayList.get(randomindex).ps_time;
        postSuitcase.ps_likes = arrayList.get(randomindex).ps_likes;
        postSuitcase.ps_comments = arrayList.get(randomindex).ps_comments;
        postSuitcase.ps_imgpost = arrayList.get(randomindex).ps_imgpost;
        postSuitcase.ps_imgprofile = arrayList.get(randomindex).ps_imgprofile;
        postSuitcase.ps_location = arrayList.get(randomindex).ps_location;
        postSuitcase.ps_profile = arrayList.get(randomindex).ps_profile;

        suitcaseArrayList.add(postSuitcase);

    }

    private void addPosts(String name,String likes,String comments, String location, String time,String captain, int postimg, int profileimg) {
        PostSuitcase postSuitcase = new PostSuitcase();

        postSuitcase.ps_name = name;
        postSuitcase.ps_likes = likes;
        postSuitcase.ps_comments = comments;
        postSuitcase.ps_captain = captain;
        postSuitcase.ps_location = location;
        postSuitcase.ps_time = time;
        postSuitcase.ps_imgpost = postimg;
        postSuitcase.ps_imgprofile = profileimg;

        postSuitcaseArrayList.add(postSuitcase);
    }

//    private void navigationDrawer() {
//
//
//        navigationView.bringToFront();
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return true;
//            }
//        });
//
//
//        carddrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (drawerLayout.isDrawerVisible(GravityCompat.START)){
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                }else {
//                    drawerLayout.openDrawer(GravityCompat.START);
//                }
//            }
//        });
//
//        animateNavDrawer();
//
//
//    }

//    private void animateNavDrawer() {
//
////        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));
//
//        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
//
//                float diffscaleoffset = slideOffset *(1 - 0.3f);
//                float offsetscale = 1 - diffscaleoffset;
//
//                relativeLayout.setScaleX(offsetscale);
//                relativeLayout.setScaleY(offsetscale);
//
//
//
//                float xoffset = drawerView.getWidth() * slideOffset;
//                float xoffsetdiff = relativeLayout.getWidth() * diffscaleoffset / 2;
//
//                float xTranslation = xoffset - xoffsetdiff;
//                relativeLayout.setTranslationX(xTranslation);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        });
//    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else {
//            super.onBackPressed();
//        }
//    }

    private void initviews() {

//        relativeLayout = findViewById(R.id.timeline_relativelayout);

        searchbarlayout = findViewById(R.id.timeline_searchbarlayout);

        toolbar = findViewById(R.id.timeline_topbar);

        bottomNavigationView = findViewById(R.id.timeline_bnv);
//        drawerLayout = findViewById(R.id.timeline_drawerlayout);

        imgsearch = findViewById(R.id.timeline_imgsearch);

        edtartist = findViewById(R.id.timeline_edtartist);

        cardmsg = findViewById(R.id.timeline_cardmsg);
//        carddrawer = findViewById(R.id.timeline_carddrawer);

        timelinerecyclerview = findViewById(R.id.timeline_postrecyclerview);

    }


}
