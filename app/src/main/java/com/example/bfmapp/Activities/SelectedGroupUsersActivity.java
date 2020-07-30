package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.Adapters.NewChatsAdapter;
import com.example.bfmapp.Adapters.SelectGroupAdapter;
import com.example.bfmapp.Adapters.SelectedGroupAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.NewChatsSuitcase;
import com.example.bfmapp.Suitcases.SelectGroupUserSuitcase;
import com.google.android.material.appbar.MaterialToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class SelectedGroupUsersActivity extends AppCompatActivity {


    RecyclerView selectedrecyclerview;

    CircularImageView groupimg;

    EditText edtgroupname;

    TextView txtcreategroup,txtselectednumbers;

    ArrayList<SelectGroupUserSuitcase> chatsSuitcaseArrayList = new ArrayList<>();

    MaterialToolbar materialToolbar;

    SelectedGroupAdapter selectedGroupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_group_users);


        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        selectedGroupAdapter = new SelectedGroupAdapter(this,chatsSuitcaseArrayList);

        txtcreategroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatsSuitcaseArrayList.clear();
//                txtselectednumbers.setText("");
                Toast.makeText(SelectedGroupUsersActivity.this, "Work in process", Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            chatsSuitcaseArrayList = bundle.getParcelableArrayList("arraylist");
            String count = bundle.getString("count");
            txtselectednumbers.setText("Selected members : "+count);

            selectedGroupAdapter.notifyDataSetChanged();

            selectedrecyclerview.setHasFixedSize(true);
            selectedrecyclerview.setNestedScrollingEnabled(false);
            selectedrecyclerview.setLayoutManager(new LinearLayoutManager(this));
            selectedrecyclerview.setAdapter(new SelectedGroupAdapter(this, chatsSuitcaseArrayList));


        }
    }

    private void initviews() {

        materialToolbar = findViewById(R.id.selected_gtoolbar);

        selectedrecyclerview = findViewById(R.id.selected_grecyclerview);

        groupimg = findViewById(R.id.selected_gprofileimg);

        edtgroupname = findViewById(R.id.selected_gedtgroupname);

        txtcreategroup = findViewById(R.id.selected_gtxtcreate);
        txtselectednumbers = findViewById(R.id.selected_gcounttxt);


    }


}
