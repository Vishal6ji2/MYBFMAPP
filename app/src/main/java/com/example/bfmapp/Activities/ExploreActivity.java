package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bfmapp.Adapters.ExFavouriteAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.ExPopularSuitcase;
import com.google.android.material.appbar.MaterialToolbar;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity {


    ViewPager2 favrecyclerview,popularrecyclerview,recartistrecyclerview;

    ArrayList<ExPopularSuitcase> favsuitcasearraylist = new ArrayList<>();

    private SlidingRootNav slidingRootNav;

    MaterialToolbar toolbar;

    ImageView imgsearch;
    EditText edtartist;
    CardView cardmsg;

    LinearLayout searchbarlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);


        initviews();


        setSupportActionBar(toolbar);


        favrecyclerviewopen();


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


        slidingRootNav =  new SlidingRootNavBuilder(ExploreActivity.this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.sidebarprofile)
                .inject();

        TextView viewprofile = findViewById(R.id.sidebar_viewprofile);

        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExploreActivity.this,UserProfileActivity.class));
                slidingRootNav.closeMenu();

            }
        });



    }

    private void favrecyclerviewopen() {

        addFavitems(R.drawable.postone);
        addFavitems(R.drawable.posttwo);
        addFavitems(R.drawable.postthree);
        addFavitems(R.drawable.postfour);
        addFavitems(R.drawable.postfive);


        favrecyclerview.setAdapter(new ExFavouriteAdapter(ExploreActivity.this,favsuitcasearraylist,favrecyclerview));
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

    }

    public void addFavitems(int imgs){
        ExPopularSuitcase favsuitcase = new ExPopularSuitcase();
        favsuitcase.popularimages = imgs;

        favsuitcasearraylist.add(favsuitcase);
    }


    private void initviews() {

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
