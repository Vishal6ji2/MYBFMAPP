package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bfmapp.Adapters.CommentsAdapter;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.CommentsSuitcase;
import com.google.android.material.appbar.MaterialToolbar;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class CommentsActivity extends AppCompatActivity {

    CircularImageView commentsprofileimg;
    TextView postcommenttxt;
    EditText edtcomment;
    MaterialToolbar materialToolbar;
    RecyclerView commentsrecyclerview;


    ArrayList<CommentsSuitcase> commentsSuitcaseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        initviews();

        setSupportActionBar(materialToolbar);
        getSupportActionBar().setTitle("Comments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addData("21 likes","2 replies","Alisa Katshow","That's very cool That's very cool,That's very cool,That's very cool,That's very cool,That's very cool ","2h",R.drawable.profileone);

        addData("10 likes","4 replies","Mia shroff","Thas very cool","2h",R.drawable.profiletwo);

        addData("11 likes","5 replies","Elina Fonser","Thas very cool","2h",R.drawable.profilethree);

        addData("57 likes","9 replies","James Cameron","Thas very cool","2h",R.drawable.profilefour);

        addData("45 likes","7 replies","Alisa Eloquent","Thas very cool","2h",R.drawable.profilefive);

        addData("23 likes","12 replies","Alisa Katshow","Thas very cool","2h",R.drawable.profileone);

        addData("36 likes","32 replies","Alisa Shroff","Thas very cool","2h",R.drawable.profiletwo);

        addData("63 likes","22 replies","Mia Katshow","Thas very cool","2h",R.drawable.profilethree);

        addData("95 likes","10 replies","Frequent.elso","Thas very cool","2h",R.drawable.profilefour);

        addData("59 likes","20 replies","Terenteeno","Thas very cool","2h",R.drawable.profilefive);


        commentsrecyclerview.setHasFixedSize(true);
        commentsrecyclerview.setNestedScrollingEnabled(false);
        commentsrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        commentsrecyclerview.setAdapter(new CommentsAdapter(this,commentsSuitcaseArrayList));

    }

    private void initviews() {

        commentsprofileimg = findViewById(R.id.comment_imgprofile);
        postcommenttxt = findViewById(R.id.comment_posttxt);
        edtcomment = findViewById(R.id.comment_edtcomment);
        materialToolbar = findViewById(R.id.comment_toolbar);
        commentsrecyclerview = findViewById(R.id.comment_comentsrecyclerview);

    }

    public void addData(String commentlikes,String commentreplies,String username,String commentline,String commenttime,int userprofileimg){

        CommentsSuitcase commentsSuitcase = new CommentsSuitcase();

        commentsSuitcase.username = username;
        commentsSuitcase.userprofileimg = userprofileimg;
        commentsSuitcase.commentlikes = commentlikes;
        commentsSuitcase.commentreplies = commentreplies;
        commentsSuitcase.commenttime = commenttime;
        commentsSuitcase.commentlines = commentline;

        commentsSuitcaseArrayList.add(commentsSuitcase);

    }
}
