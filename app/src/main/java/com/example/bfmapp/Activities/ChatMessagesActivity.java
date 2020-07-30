package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.Bottomsheetdialog;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ChatMessagesActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;

    ImageView emojiimg,attachfileimg,micimg,sendimg;

    EditText edtmsg;

    CircularImageView chatterprofileimg;

    TextView chattername;

    RecyclerView cmrecyclerview;

    BottomSheetDialog bottomSheetDialog,bottomSheetDialog1;

    LinearLayout llmsgbottomsheetlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        initviews();

        setSupportActionBar(materialToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        if (getIntent()!=null){

            if (getIntent().getStringExtra("chattername")!=null ) {
                String username = getIntent().getStringExtra("chattername");
                int userprofile = getIntent().getIntExtra("chatterimg", R.drawable.passwordicon);

                chattername.setText(username);
                chatterprofileimg.setImageResource(userprofile);

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.msgmenu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.msgmenu){

            bottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);


            final View bottomsheetmenus = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.msgbottomsheet,llmsgbottomsheetlayout);

            bottomsheetmenus.findViewById(R.id.bschat_llsearchmsg).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Search message", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llblock).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "blocked ", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();


                    openBlockBottomSheet(bottomSheetDialog1);
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_lldeletechat).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "delete message", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    openDeleteBottomSheet(bottomSheetDialog1);
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llmutemsg).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialog.dismiss();
                    openMutemsgBottomsheet(bottomSheetDialog1);
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llreport).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Reported", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    openReportBottomsheet(bottomSheetDialog1);
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llshareprofile).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Share Profile", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                }
            });

            bottomSheetDialog.setContentView(bottomsheetmenus);
            bottomSheetDialog.show();

        }

        return true;
    }

    private void initviews() {

        llmsgbottomsheetlayout = findViewById(R.id.llmsgbottomsheet);

        materialToolbar = findViewById(R.id.cm_toolbar);

        emojiimg = findViewById(R.id.cm_emojiimg);
        attachfileimg = findViewById(R.id.cm_attachimg);
        micimg = findViewById(R.id.cm_micimg);
        sendimg = findViewById(R.id.cm_sendimg);

        edtmsg = findViewById(R.id.cm_edtmsg);

        chattername = findViewById(R.id.cm_chattername);
        chatterprofileimg = findViewById(R.id.cm_chatterimg);

        cmrecyclerview = findViewById(R.id.cm_recyclerview);
    }

    public void openMutemsgBottomsheet(BottomSheetDialog mmbottomSheetDialog){
        mmbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);
        final SwitchCompat switchCompat = findViewById(R.id.mm_switch);
        final AppCompatCheckBox checkBox = findViewById(R.id.mm_checkbox);

        final LinearLayout mmllbottomsheet = findViewById(R.id.mm_llbottomsheet);
        Toast.makeText(ChatMessagesActivity.this, "Mute enabled", Toast.LENGTH_SHORT).show();
//        bottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);
        final View mmview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.mutemsgbottomsheet,mmllbottomsheet);

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()){
                    Toast.makeText(ChatMessagesActivity.this, "Mute message", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ChatMessagesActivity.this, "Unmute message", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    Toast.makeText(ChatMessagesActivity.this, "show notification", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ChatMessagesActivity.this, "mute notificatin ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final BottomSheetDialog finalMmbottomSheetDialog = mmbottomSheetDialog;
        mmview.findViewById(R.id.mm_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalMmbottomSheetDialog.dismiss();
            }
        });

        mmbottomSheetDialog.setContentView(mmview);
        mmbottomSheetDialog.show();

    }

    public void openReportBottomsheet(BottomSheetDialog reportbottomSheetDialog){

        reportbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);
        final LinearLayout reportllbottomsheet = findViewById(R.id.report_llbottomsheet);
        Toast.makeText(ChatMessagesActivity.this, "Mute enabled", Toast.LENGTH_SHORT).show();
//        bottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);
        final View reportview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.reportbottomsheet,reportllbottomsheet);

        reportbottomSheetDialog.setContentView(reportview);
        reportbottomSheetDialog.show();

        final BottomSheetDialog finalReportbottomSheetDialog1 = reportbottomSheetDialog;
        reportview.findViewById(R.id.report_inappropriatetxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Inappropriate message", Toast.LENGTH_SHORT).show();
                finalReportbottomSheetDialog1.dismiss();
            }
        });

        final BottomSheetDialog finalReportbottomSheetDialog2 = reportbottomSheetDialog;
        reportview.findViewById(R.id.report_spamtxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Spam", Toast.LENGTH_SHORT).show();
                    finalReportbottomSheetDialog2.dismiss();
              }
        });

        final BottomSheetDialog finalReportbottomSheetDialog = reportbottomSheetDialog;
        reportview.findViewById(R.id.report_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalReportbottomSheetDialog.dismiss();
            }
        });

        reportbottomSheetDialog.setContentView(reportview);
        reportbottomSheetDialog.show();
    }


    public void openBlockBottomSheet(BottomSheetDialog blockbottomSheetDialog){

        blockbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);

        LinearLayout llblocklayout = findViewById(R.id.llblockbottomsheet);

        View blockview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.blockbottomsheet,llblocklayout);

        final AppCompatCheckBox checkBox = blockview.findViewById(R.id.bl_checkbox);


        blockbottomSheetDialog.setContentView(blockview);
        blockbottomSheetDialog.show();

//        deleteview.findViewById(R.id.dl_txtusername)

        final BottomSheetDialog finalDeletebottomSheetDialog = blockbottomSheetDialog;
        blockview.findViewById(R.id.bl_blocktxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "User Blocked", Toast.LENGTH_SHORT).show();
                finalDeletebottomSheetDialog.dismiss();
            }
        });

        final BottomSheetDialog finalDeletebottomSheetDialog1 = blockbottomSheetDialog;
        blockview.findViewById(R.id.bl_txtcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                finalDeletebottomSheetDialog1.dismiss();
            }
        });

        final BottomSheetDialog finalDeletebottomSheetDialog2 = blockbottomSheetDialog;
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    Toast.makeText(ChatMessagesActivity.this, "Delete Chat", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ChatMessagesActivity.this, "Chat not deleted", Toast.LENGTH_SHORT).show();
                }
                finalDeletebottomSheetDialog2.dismiss();
            }
        });


        blockbottomSheetDialog.setContentView(blockview);
        blockbottomSheetDialog.show();
    }


    public void openDeleteBottomSheet(BottomSheetDialog deletebottomSheetDialog){

        deletebottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);

        LinearLayout lldeletelayout = findViewById(R.id.lldeletebottomsheet);

        View deleteview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.deletebottomsheet,lldeletelayout);


        deletebottomSheetDialog.setContentView(deleteview);
        deletebottomSheetDialog.show();


        final BottomSheetDialog finalDeletebottomSheetDialog = deletebottomSheetDialog;
        deleteview.findViewById(R.id.dl_deletetxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Delete chat", Toast.LENGTH_SHORT).show();
                finalDeletebottomSheetDialog.dismiss();
            }
        });

        final BottomSheetDialog finalDeletebottomSheetDialog1 = deletebottomSheetDialog;
        deleteview.findViewById(R.id.dl_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                finalDeletebottomSheetDialog1.dismiss();
            }
        });

        deletebottomSheetDialog.setContentView(deleteview);
        deletebottomSheetDialog.show();
    }

}