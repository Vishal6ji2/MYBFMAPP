package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.bfmapp.Adapters.SelectGroupAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.example.bfmapp.Suitcases.SelectGroupUserSuitcase;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class SelectGroupUsersActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    RecyclerView selectrecyclerview;

  public static   ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList = new ArrayList<>();

   public static ArrayList<SelectGroupUserSuitcase> selectedchatssuitcasearraylist = new ArrayList<>();

    SelectGroupAdapter selectGroupAdapter;

    public static String selecteditem;


   public static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_group_users);

        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setTitle("New Group");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectGroupAdapter = new SelectGroupAdapter();


        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chatsSuitcaseArrayList.clear();

        addData("Mia Shroff",R.drawable.profileone);
        addData("Alisa Katshow",R.drawable.profiletwo);
        addData("Photographer.freak",R.drawable.profilethree);
        addData("Elina Fonser",R.drawable.profilefour);
        addData("Alina kat",R.drawable.profilefive);
        addData("James cameron",R.drawable.profileone);
        addData("Jackquline",R.drawable.profiletwo);


        selectrecyclerview.setHasFixedSize(true);
        selectrecyclerview.setNestedScrollingEnabled(false);
        selectrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        selectrecyclerview.setAdapter(new SelectGroupAdapter(this,chatsSuitcaseArrayList));

    }

    private void initviews() {

        materialToolbar = findViewById(R.id.selectg_toolbar);

        selectrecyclerview = findViewById(R.id.selectg_recyclerview);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.selectmenu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.selectadd_menu){


            Log.d("arraylist",selectedchatssuitcasearraylist.get(0).username+selecteditem);

            Intent intent = new Intent(SelectGroupUsersActivity.this,SelectedGroupUsersActivity.class);

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("arraylist",selectedchatssuitcasearraylist);
            bundle.putString("count",selecteditem);
            intent.putExtras(bundle);
//            intent.putExtra("count",selecteditem);
            Toast.makeText(this, selectedchatssuitcasearraylist.get(0).username+selecteditem, Toast.LENGTH_SHORT).show();

            startActivity(intent);
        }

        return true;
    }


    public void addData(String username,int profileimg){

        SelectGroupUserSuitcase selectGroupUserSuitcase = new SelectGroupUserSuitcase();
        selectGroupUserSuitcase.username = username;
        selectGroupUserSuitcase.profileimg = profileimg;

        chatsSuitcaseArrayList.add(selectGroupUserSuitcase);
    }

    public static void MakeSelection(View v, int adapterPosition) {

        if (((AppCompatCheckBox)v).isChecked()){
            selectedchatssuitcasearraylist.add(chatsSuitcaseArrayList.get(adapterPosition));
            counter++;
            updatecounter();
        }else {
            selectedchatssuitcasearraylist.remove(chatsSuitcaseArrayList.get(adapterPosition));
            counter--;
            updatecounter();
        }

    }

    public static void  updatecounter(){
        selecteditem = String.valueOf(counter);
    }
}
