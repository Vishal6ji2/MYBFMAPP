package com.example.bfmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.Bottomsheetdialog;
import com.example.bfmapp.OtherUsersProfileActivity;
import com.example.bfmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.skyfishjy.library.RippleBackground;

import java.io.IOException;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class ChatMessagesActivity extends AppCompatActivity {

    RelativeLayout rootlayout;

    MaterialToolbar materialToolbar;

    ImageView emojiimg,attachfileimg,micimg,sendimg;

    EmojiconEditText edtmsg;

    EmojIconActions iconActions;

    CircularImageView chatterprofileimg;

    TextView chattername;

    RecyclerView cmrecyclerview;

    EmojiconTextView textView;

    BottomSheetDialog bottomSheetDialog;

    LinearLayout llmsgbottomsheetlayout;

    MediaRecorder recorder;

    String fileName = null;
    String username;
    int userprofile;

    RippleBackground rippleBackground ;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        initviews();

        rippleBackground = findViewById(R.id.ripplebackground);

        textView = findViewById(R.id.textview);

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
                username = getIntent().getStringExtra("chattername");
                userprofile = getIntent().getIntExtra("chatterimg", R.drawable.passwordicon);

                chattername.setText(username);
                chatterprofileimg.setImageResource(userprofile);

            }
        }

        edtmsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!edtmsg.getText().toString().isEmpty()) {
                    micimg.setVisibility(View.GONE);
                    sendimg.setVisibility(View.VISIBLE);
                }else {
                    micimg.setVisibility(View.VISIBLE);
                    sendimg.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        chattername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatMessagesActivity.this, OtherUsersProfileActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("userimg",userprofile);

                startActivity(intent);
            }
        });

        chatterprofileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatMessagesActivity.this, OtherUsersProfileActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("userimg",userprofile);

                startActivity(intent);
            }
        });

        iconActions = new EmojIconActions(this,rootlayout,edtmsg,emojiimg);
        iconActions.ShowEmojIcon();
        iconActions.setIconsIds(R.drawable.ic_action_keyboard,R.drawable.emojiicon);

        iconActions.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {

//                Toast.makeText(ChatMessagesActivity.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onKeyboardClose() {

//                Toast.makeText(ChatMessagesActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }
        });

        sendimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(edtmsg.getText().toString());
            }
        });

        fileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        fileName += "/recorded_audio.mp3";

        micimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Hold mic to record audio", Toast.LENGTH_SHORT).show();
            }
        });

        micimg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        textView.setText("Start Recording");
                        startRecording();
                        rippleBackground.startRippleAnimation();

                        return true;

                    case MotionEvent.ACTION_UP:
                        textView.setText("Stop recording");
                        stopRecording();
                        rippleBackground.stopRippleAnimation();
                        return true;
                }

                return false;
            }
        });
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
//            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
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

                    openBlockBottomSheet();
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_lldeletechat).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "delete message", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    openDeleteBottomSheet();
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llmutemsg).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bottomSheetDialog.dismiss();
                    openMutemsgBottomsheet();
                }
            });

            bottomsheetmenus.findViewById(R.id.bschat_llreport).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Reported", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                    openReportBottomsheet();
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

        rootlayout = findViewById(R.id.cm_rootlayout);

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

    public void openMutemsgBottomsheet(){
        final BottomSheetDialog  mmbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);


        final LinearLayout mmllbottomsheet = findViewById(R.id.mm_llbottomsheet);
        final View mmview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.mutemsgbottomsheet,mmllbottomsheet);
        final SwitchCompat switchCompat = mmview.findViewById(R.id.mm_switch);
        final AppCompatCheckBox checkBox = mmview.findViewById(R.id.mm_checkbox);
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

//        final BottomSheetDialog finalMmbottomSheetDialog = mmbottomSheetDialog;
        mmview.findViewById(R.id.mm_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmbottomSheetDialog.dismiss();
            }
        });

        mmbottomSheetDialog.setContentView(mmview);
        mmbottomSheetDialog.show();

    }

    public void openReportBottomsheet(){

        final BottomSheetDialog  reportbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);
        final LinearLayout reportllbottomsheet = findViewById(R.id.report_llbottomsheet);

        final View reportview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.reportbottomsheet,reportllbottomsheet);

        reportview.findViewById(R.id.report_inappropriatetxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Inappropriate message", Toast.LENGTH_SHORT).show();
                reportbottomSheetDialog.dismiss();
            }
        });

        reportview.findViewById(R.id.report_spamtxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(ChatMessagesActivity.this, "Spam", Toast.LENGTH_SHORT).show();
                reportbottomSheetDialog.dismiss();
              }
        });

//        final BottomSheetDialog finalReportbottomSheetDialog = reportbottomSheetDialog;
        reportview.findViewById(R.id.report_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportbottomSheetDialog.dismiss();
            }
        });

        reportbottomSheetDialog.setContentView(reportview);
        reportbottomSheetDialog.show();
    }


    public void openBlockBottomSheet(){

      final BottomSheetDialog  blockbottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);

       final LinearLayout llblocklayout = findViewById(R.id.llblockbottomsheet);

       final View blockview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.blockbottomsheet,llblocklayout);

        final AppCompatCheckBox checkBox = blockview.findViewById(R.id.bl_checkbox);


        blockview.findViewById(R.id.bl_blocktxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "User Blocked", Toast.LENGTH_SHORT).show();
                blockbottomSheetDialog.dismiss();
            }
        });

        blockview.findViewById(R.id.bl_txtcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                blockbottomSheetDialog.dismiss();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    Toast.makeText(ChatMessagesActivity.this, "Delete Chat", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ChatMessagesActivity.this, "Chat not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });


        blockbottomSheetDialog.setContentView(blockview);
        blockbottomSheetDialog.show();
    }


    public void openDeleteBottomSheet(){

      final BottomSheetDialog  deletebottomSheetDialog = new BottomSheetDialog(ChatMessagesActivity.this);

        LinearLayout lldeletelayout = findViewById(R.id.lldeletebottomsheet);

        View deleteview = LayoutInflater.from(ChatMessagesActivity.this).inflate(R.layout.deletebottomsheet,lldeletelayout);


//        final BottomSheetDialog finalDeletebottomSheetDialog = deletebottomSheetDialog;
        deleteview.findViewById(R.id.dl_deletetxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Delete chat", Toast.LENGTH_SHORT).show();
                deletebottomSheetDialog.dismiss();
            }
        });

//        final BottomSheetDialog finalDeletebottomSheetDialog1 = deletebottomSheetDialog;
        deleteview.findViewById(R.id.dl_canceltxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatMessagesActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                deletebottomSheetDialog.dismiss();
            }
        });

        deletebottomSheetDialog.setContentView(deleteview);
        deletebottomSheetDialog.show();
    }

}
