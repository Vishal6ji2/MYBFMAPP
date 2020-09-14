package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bfmapp.Adapters.ChartsFragmentAdapter;
import com.example.bfmapp.Fragments.AgeChartFragment;
import com.example.bfmapp.Fragments.GenderPiechartFragment;
import com.example.bfmapp.Fragments.LocationsChartFragment;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

public class YourActivitySettingActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    ImageView arrowimg;

    LinearLayout lldetails;

    SpringDotsIndicator dotsIndicator;

    TextView txtyes,txtno,txtarrow;

    ViewPager viewPager;

    ChartsFragmentAdapter chartsFragmentAdapter;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_setting);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Promotion Insights");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        lldetails.setVisibility(View.GONE);

        fragmentArrayList.add(new GenderPiechartFragment());
        fragmentArrayList.add(new LocationsChartFragment());
        fragmentArrayList.add(new AgeChartFragment());

        chartsFragmentAdapter = new ChartsFragmentAdapter(getSupportFragmentManager(),fragmentArrayList);

        viewPager.setAdapter(chartsFragmentAdapter);

        dotsIndicator.setViewPager(viewPager);

        txtarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 0){
                    rotateAnim(arrowimg);
                    lldetails.setVisibility(View.VISIBLE);
                    flag = 1;
                }else if (flag == 1){
                    rotateAnim(arrowimg);
                    lldetails.setVisibility(View.GONE);
                    flag = 0;
                }

            }
        });

        arrowimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == 0){
                    rotateAnim(arrowimg);
                    lldetails.setVisibility(View.VISIBLE);
                    flag = 1;
                }else if (flag == 1){
                    rotateAnim(arrowimg);
                    lldetails.setVisibility(View.GONE);
                    flag = 0;
                }

            }
        });

    }

    public void rotateAnim(View view){

        RotateAnimation rotateAnimation = new RotateAnimation(0,180,RotateAnimation.RELATIVE_TO_SELF,.5f,RotateAnimation.RELATIVE_TO_SELF,.5f);

        rotateAnimation.setDuration(500);

        view.startAnimation(rotateAnimation);
    }


    private void initviews() {

        dotsIndicator = findViewById(R.id.ya_dotsindicator);

        viewPager = findViewById(R.id.ya_viewpager);

        materialToolbar = findViewById(R.id.ya_toolbar);

        txtarrow = findViewById(R.id.ya_txtinsights);

        lldetails = findViewById(R.id.ya_lldetails);

        arrowimg = findViewById(R.id.ya_imgarrowdown);
        txtyes = findViewById(R.id.ya_txtyes);
        txtno = findViewById(R.id.ya_txtno);

    }
}
