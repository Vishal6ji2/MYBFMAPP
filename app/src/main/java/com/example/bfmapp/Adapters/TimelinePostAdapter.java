package com.example.bfmapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.example.bfmapp.Activities.ChatMessagesActivity;
import com.example.bfmapp.Activities.CommentsActivity;
import com.example.bfmapp.Activities.CreateProposalActivity;
import com.example.bfmapp.Activities.LikesActivity;
import com.example.bfmapp.Activities.ProposalsActivity;
import com.example.bfmapp.Fragments.BlockedAccountsFragment;
import com.example.bfmapp.Heart;
import com.example.bfmapp.OtherUsersProfileActivity;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.PostSuitcase;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.util.ArrayList;

public class TimelinePostAdapter extends RecyclerView.Adapter<TimelinePostAdapter.ViewHolder> {
    Context context;
   public ArrayList<PostSuitcase> postSuitcaseArrayList = new ArrayList<>();

   GestureDetector gestureDetector;

   Heart heart;

   int linecount = 0;

    public TimelinePostAdapter(Context context, ArrayList<PostSuitcase> postSuitcaseArrayList) {
        this.context = context;
        this.postSuitcaseArrayList = postSuitcaseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


//        gestureDetector = new GestureDetector(context,new GestureListener());
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.customtimelineposts,parent,false));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

      holder.imgcomment.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              context.startActivity(new Intent(context,CommentsActivity.class));
          }
      });

        holder.imgprofile.setImageResource(postSuitcaseArrayList.get(position).ps_imgprofile);

        holder.txtprofilename.setText(postSuitcaseArrayList.get(position).ps_name);

        holder.imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtherUsersProfileActivity.class);
                intent.putExtra("username",postSuitcaseArrayList.get(position).ps_name);
                intent.putExtra("userimg",postSuitcaseArrayList.get(position).ps_imgprofile);

                context.startActivity(intent);

            }
        });

        holder.txtprofilename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OtherUsersProfileActivity.class);
                intent.putExtra("username",postSuitcaseArrayList.get(position).ps_name);
                intent.putExtra("userimg",postSuitcaseArrayList.get(position).ps_imgprofile);

                context.startActivity(intent);

            }
        });

        holder.txttime.setText(postSuitcaseArrayList.get(position).ps_time);

        holder.imgpost.setImageResource(postSuitcaseArrayList.get(position).ps_imgpost);

        holder.txtlikes.setText(postSuitcaseArrayList.get(position).ps_likes);

        holder.txtlikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, LikesActivity.class));
            }
        });

        holder.txtcomments.setText(postSuitcaseArrayList.get(position).ps_comments);

        holder.txtcomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CommentsActivity.class));
            }
        });

        holder.txtlocation.setText(postSuitcaseArrayList.get(position).ps_location);

        postSuitcaseArrayList.get(position).ps_redheartimg = holder.imgredlike;

        postSuitcaseArrayList.get(position).ps_blackheartimg = holder.imgblacklike;

        postSuitcaseArrayList.get(position).ps_redheartimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postSuitcaseArrayList.get(position).ps_redheartimg.setVisibility(View.INVISIBLE);
                postSuitcaseArrayList.get(position).ps_blackheartimg.setVisibility(View.VISIBLE);
            }
        });

        postSuitcaseArrayList.get(position).ps_blackheartimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postSuitcaseArrayList.get(position).ps_blackheartimg.setVisibility(View.INVISIBLE);
                postSuitcaseArrayList.get(position).ps_redheartimg.setVisibility(View.VISIBLE);
            }
        });

        holder.imgmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetDialogTheme);

                View bottomsheetview = LayoutInflater.from(context).inflate(R.layout.bottomsheet_details,holder.bslinearlayout);

                bottomsheetview.findViewById(R.id.bs_llunfollow).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, ""+postSuitcaseArrayList.get(position).ps_name+" unfollow", Toast.LENGTH_SHORT).show();
                        postSuitcaseArrayList.remove(position);
                        notifyDataSetChanged();
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llblock).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, ""+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();

                        postSuitcaseArrayList.remove(position);
                        notifyDataSetChanged();


  /*                      Bundle intent = new Bundle();
                        intent.putString("blockedname",postSuitcaseArrayList.get(position).ps_name);
                        intent.putInt("blockedimg",postSuitcaseArrayList.get(position).ps_imgprofile);
*/
                      /*  BlockedAccountsFragment blockedAccountsFragment = new BlockedAccountsFragment();
                        blockedAccountsFragment.setArguments(intent);
                        bottomSheetDialog.dismiss();
                        AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.prisetting_fragcontainer,blockedAccountsFragment).addToBackStack(null).commit();
*/
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llmsguser).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, ChatMessagesActivity.class);
                        intent.putExtra("chattername",postSuitcaseArrayList.get(position).ps_name);
                        intent.putExtra("chatterimg",postSuitcaseArrayList.get(position).ps_imgprofile);
                        bottomSheetDialog.dismiss();
                        context.startActivity(intent);
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llproposal).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, CreateProposalActivity.class);
                        intent.putExtra("propname",postSuitcaseArrayList.get(position).ps_name);
                        intent.putExtra("propprofileimg",postSuitcaseArrayList.get(position).ps_imgprofile);
                        bottomSheetDialog.dismiss();
                        context.startActivity(intent);
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llreport).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Reported", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llrequest).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llshare).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

/*
                        File file = new File(context.getExternalCacheDir(),String.valueOf(postSuitcaseArrayList.get(position).ps_imgpost));
                        file.setReadable(true,false);

                        int[] ids = new int[]{postSuitcaseArrayList.size()};

                      Uri uri =   FileProvider.getUriForFile(context, context.getPackageName()+".fileprovider", file);

                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Intent.EXTRA_TEXT,postSuitcaseArrayList.get(position).ps_name);
                        intent.putExtra(Intent.EXTRA_STREAM,uri);
                        intent.setType("image/*");
                        context.startActivity(Intent.createChooser(intent,"Share via "));
*/


                        Toast.makeText(context, "Share in future:"+postSuitcaseArrayList.get(position).ps_name+" post", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(bottomsheetview);
                bottomSheetDialog.show();

            }
        });
        postSuitcaseArrayList.get(position).justifiedTextView = holder.txtpostcaptain ;

        postSuitcaseArrayList.get(position).justifiedTextView.getLineCount();

        holder.txtpostcaptain.setText(Html.fromHtml(postSuitcaseArrayList.get(position).ps_captain));

       linecount = postSuitcaseArrayList.get(position).justifiedTextView.getLineCount();
       if (linecount>2){
           holder.txtmore.setVisibility(View.VISIBLE);
//           Toast.makeText(context, ""+linecount, Toast.LENGTH_SHORT).show();

       }else {
           holder.txtmore.setVisibility(View.GONE);
//           Toast.makeText(context, ""+linecount, Toast.LENGTH_SHORT).show();
       }

        holder.txtmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, ""+linecount, Toast.LENGTH_SHORT).show();
                holder.txtpostcaptain.setMaxLines(linecount);
                Toast.makeText(context, ""+linecount, Toast.LENGTH_SHORT).show();

                holder.txtmore.setVisibility(View.GONE);
            }
        });

       /* holder.imgredlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart.toggleLike();
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return postSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FrameLayout bslinearlayout;

        ImageView imgprofile,imgpost,imgmenu,imgblacklike,imgredlike,imgcomment,imgshare,imgbookmark;
        TextView txtprofilename,txtlocation,txttime,txtlikes,txtcomments,txtmore;

        JustifiedTextView txtpostcaptain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            bslinearlayout = itemView.findViewById(R.id.bs_linearlayout);

            imgprofile = itemView.findViewById(R.id.post_imgprofile);
            imgpost = itemView.findViewById(R.id.post_imgpost);
            imgmenu = itemView.findViewById(R.id.post_imgmenu);
            imgblacklike = itemView.findViewById(R.id.post_imgblackheartlike);
            imgredlike = itemView.findViewById(R.id.post_imgblueheartlike);
            imgcomment = itemView.findViewById(R.id.post_imgcomment);
            imgshare = itemView.findViewById(R.id.post_imgshare);
            imgbookmark = itemView.findViewById(R.id.post_imgbookmark);
            txtprofilename = itemView.findViewById(R.id.post_txtname);
            txtlocation = itemView.findViewById(R.id.post_txtlocation);
            txttime = itemView.findViewById(R.id.post_txttime);
            txtlikes = itemView.findViewById(R.id.post_txtlikes);
            txtcomments = itemView.findViewById(R.id.post_txtcomments);
            txtpostcaptain = itemView.findViewById(R.id.post_txtcaptain);
            txtmore = itemView.findViewById(R.id.post_txtmore);
        }
    }


   /* public class GestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("likes","motion down");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("likes","motion down");
            heart.toggleLike();
            return true;
        }
    }*/
}
