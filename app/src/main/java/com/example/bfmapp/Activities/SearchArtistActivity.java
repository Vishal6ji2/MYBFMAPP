package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.bfmapp.Adapters.ChatUsersAdapter;
import com.example.bfmapp.Adapters.NotiTabAdapter;
import com.example.bfmapp.Adapters.SearchTabAdapter;
import com.example.bfmapp.CaptureAct;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class SearchArtistActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabLayoutMediator tabLayoutMediator;

    MaterialToolbar materialToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_artist);

        initviews();

        setSupportActionBar(materialToolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        materialToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchArtistActivity.this,FinalSearchActivity.class);

                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

            }
        });

        prepareViewpager(viewPager2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchmenus,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.sm_filter) {
            IntentIntegrator integrator = new IntentIntegrator(SearchArtistActivity.this);
            integrator.setCaptureActivity(CaptureAct.class);
            integrator.setOrientationLocked(false);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            integrator.setPrompt("Scanning code");
            integrator.initiateScan();
            Toast.makeText(this, "filter", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.sm_search) {


            Intent intent = new Intent(SearchArtistActivity.this,FinalSearchActivity.class);

            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

//            startActivity(new Intent(SearchArtistActivity.this,FinalSearchActivity.class));

//            SearchView searchView = (SearchView) item.getActionView();

           /* searchView.setQueryHint("Search your artist");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {


                    return false;
                }
            });
        }
*/
        }
            return true;

        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (result!=null){
            if (result.getContents()!=null){
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No Result", Toast.LENGTH_SHORT).show();
            }
        }else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    private void prepareViewpager(ViewPager2 viewPager2) {

        viewPager2.setAdapter(new SearchTabAdapter(this));

        tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("People");
                        break;
                    case 1:
                        tab.setText("Category");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

    }

    private void initviews() {

        tabLayout = findViewById(R.id.sa_tablayout);

        materialToolbar = findViewById(R.id.sa_toolbar);

        viewPager2 = findViewById(R.id.sa_viewpager2);

    }
}
