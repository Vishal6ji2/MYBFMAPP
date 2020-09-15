package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bfmapp.Adapters.ExFavouriteAdapter;
import com.example.bfmapp.Adapters.ExPopularAdapter;
import com.example.bfmapp.Adapters.ExRecArtistAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ExPopularSuitcase;
import com.example.bfmapp.Suitcases.ExRecArtistSuitcase;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;

    BottomNavigationView bottomNavigationView;

    RecyclerView favrecyclerview,popularrecyclerview,recartistrecyclerview;

    ArrayList<ExPopularSuitcase> popularSuitcaseArrayList = new ArrayList<>();
    ArrayList<ExPopularSuitcase> favsuitcasearraylist = new ArrayList<>();
    ArrayList<ExRecArtistSuitcase> recArtistSuitcaseArrayList = new ArrayList<>();

//    private SlidingRootNav slidingRootNav;

    MaterialToolbar toolbar;

    ImageView imgsearch;
    TextView edtartist;
    CardView cardmsg,carddrawer;

    LinearLayout searchbarlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        initviews();


        setSupportActionBar(toolbar);

        bottomNavigationView.setSelectedItemId(R.id.bnav_browser);

        Openpopularrecyclerview();

        Openrecartistrecyclerview();

        Openfavrecyclerview();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.bnav_noti){

                    startActivity(new Intent(ExploreActivity.this,NotificationActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_home){
                    startActivity(new Intent(ExploreActivity.this,TimelinepostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }else if (item.getItemId() == R.id.bnav_browser){
                    return true;
                }else if (item.getItemId() == R.id.bnav_add){
                    startActivity(new Intent(ExploreActivity.this,CreatePostActivity.class));
                    overridePendingTransition(0,0);
                    finish();
                }/*else if (item.getItemId() == R.id.bnav_sidebar){
                    startActivity(new Intent(ExploreActivity.this,SideBarActivity.class));
                    overridePendingTransition(0,0);
                }*/

                return true;
            }
        });


        carddrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });


        searchbarlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });


        edtartist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,SearchArtistActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

        cardmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,ChatUsersActivity.class));
            }
        });


       /* slidingRootNav =  new SlidingRootNavBuilder(ExploreActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.sidebarprofile)
                .inject();*/

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
                startActivity(new Intent(ExploreActivity.this,SavedPostsActivity.class));
            }
        });

        myqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,YourQrCodeActivity.class));
                closeDrawer(drawerLayout);
            }
        });

        viewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,LoginActivity.class));
//                slidingRootNav.closeMenu();
                finish();
                closeDrawer(drawerLayout);
            }
        });

        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewusername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,UserProfileActivity.class));
//                slidingRootNav.closeMenu();
                closeDrawer(drawerLayout);
            }
        });

        viewsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,SettingsActivity.class));
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


    private void Openpopularrecyclerview() {

        addPopulardata(R.drawable.girlthree);
        addPopulardata(R.drawable.posttwo);
        addPopulardata(R.drawable.postthree);
        addPopulardata(R.drawable.girlone);
        addPopulardata(R.drawable.girltwo);
        addPopulardata(R.drawable.postone);
        addPopulardata(R.drawable.posttwo);
        addPopulardata(R.drawable.postthree);
        addPopulardata(R.drawable.girltwo);
        addPopulardata(R.drawable.girlone);


        popularrecyclerview.setHasFixedSize(true);
        popularrecyclerview.setNestedScrollingEnabled(false);
        popularrecyclerview.setItemAnimator(new DefaultItemAnimator());
        popularrecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        popularrecyclerview.setAdapter(new ExPopularAdapter(ExploreActivity.this,popularSuitcaseArrayList));
    }

    public void addPopulardata(int imgs){

        ExPopularSuitcase exPopularSuitcase = new ExPopularSuitcase();
        exPopularSuitcase.popularimages = imgs;

        popularSuitcaseArrayList.add(exPopularSuitcase);

    }

    private void Openrecartistrecyclerview() {

        addRecartistitems("Alisa elequent",R.drawable.postone,R.drawable.profileone);
        addRecartistitems("James Cameron",R.drawable.posttwo,R.drawable.profiletwo);
        addRecartistitems("MartiaZumba",R.drawable.postthree,R.drawable.profilethree);
        addRecartistitems("RickyFlamen",R.drawable.postfour,R.drawable.profilefour);
        addRecartistitems("Hensberginia quent",R.drawable.postfive,R.drawable.profilefive);
        addRecartistitems("Alisa elequent",R.drawable.postone,R.drawable.profileone);
        addRecartistitems("James Cameron",R.drawable.posttwo,R.drawable.profiletwo);
        addRecartistitems("MartiaZumba",R.drawable.postthree,R.drawable.profilethree);
        addRecartistitems("RickyFlamen",R.drawable.postfour,R.drawable.profilefour);
        addRecartistitems("Hensberginia quent",R.drawable.postfive,R.drawable.profilefive);


        recartistrecyclerview.setHasFixedSize(true);
        recartistrecyclerview.setNestedScrollingEnabled(false);
        recartistrecyclerview.setItemAnimator(new DefaultItemAnimator());
        recartistrecyclerview.setLayoutManager(new LinearLayoutManager(ExploreActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recartistrecyclerview.setAdapter(new ExRecArtistAdapter(ExploreActivity.this,recArtistSuitcaseArrayList));
    }

    public void addRecartistitems(String username,int lastpostimg,int profileimg){

        ExRecArtistSuitcase exRecArtistSuitcase = new ExRecArtistSuitcase();
        exRecArtistSuitcase.lastpost = lastpostimg;
        exRecArtistSuitcase.profileimg = profileimg;
        exRecArtistSuitcase.username = username;


        recArtistSuitcaseArrayList.add(exRecArtistSuitcase);
    }

    private void Openfavrecyclerview() {

        addFavitems(R.drawable.postone);
        addFavitems(R.drawable.posttwo);
        addFavitems(R.drawable.postthree);
        addFavitems(R.drawable.postfour);
        addFavitems(R.drawable.postfive);


        favrecyclerview.setHasFixedSize(true);
        favrecyclerview.setNestedScrollingEnabled(false);
        favrecyclerview.setItemAnimator(new DefaultItemAnimator());
        favrecyclerview.setLayoutManager(new LinearLayoutManager(ExploreActivity.this, LinearLayoutManager.HORIZONTAL,false));
        favrecyclerview.setAdapter(new ExFavouriteAdapter(ExploreActivity.this,favsuitcasearraylist));
/*
        favrecyclerview.setClipToPadding(false);
        favrecyclerview.setClipChildren(true);
        favrecyclerview.setOffscreenPageLimit(3);
        favrecyclerview.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.95f + r *0.05f);
            }
        });

        favrecyclerview.setPageTransformer(compositePageTransformer);
*/

    }

    public void addFavitems(int imgs){
        ExPopularSuitcase favsuitcase = new ExPopularSuitcase();
        favsuitcase.popularimages = imgs;

        favsuitcasearraylist.add(favsuitcase);
    }


    private void initviews() {

        carddrawer = findViewById(R.id.timeline_carddrawer);

        drawerLayout = findViewById(R.id.timeline_drawerlayout);

        bottomNavigationView = findViewById(R.id.timeline_bnv);

        recartistrecyclerview = findViewById(R.id.explore_rec_artistrecyclerview);
        favrecyclerview = findViewById(R.id.explore_favrecyclerview);
        popularrecyclerview = findViewById(R.id.explore_popularrecyclerview);

        searchbarlayout = findViewById(R.id.timeline_searchbarlayout);

        toolbar = findViewById(R.id.timeline_topbar);

        imgsearch = findViewById(R.id.timeline_imgsearch);

        edtartist = findViewById(R.id.timeline_edtartist);

        cardmsg = findViewById(R.id.timeline_cardmsg);
    }
}
