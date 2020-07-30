package com.example.bfmapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bfmapp.Activities.CommentsActivity;
import com.example.bfmapp.Activities.LikesActivity;
import com.example.bfmapp.Heart;
import com.example.bfmapp.R;
import com.example.bfmapp.Suitcases.PostSuitcase;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class TimelinePostAdapter extends RecyclerView.Adapter<TimelinePostAdapter.ViewHolder> {
    Context context;
   public   ArrayList<PostSuitcase> postSuitcaseArrayList = new ArrayList<>();

   GestureDetector gestureDetector;

   Heart heart;

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
//
      /*  holder.imgblacklike.setVisibility(View.VISIBLE);
        holder.imgredlike.setVisibility(View.GONE);
        heart = new Heart(holder.imgblacklike,holder.imgredlike,position);
*/
        holder.imgprofile.setImageResource(postSuitcaseArrayList.get(position).ps_imgprofile);

        holder.txtprofilename.setText(postSuitcaseArrayList.get(position).ps_name);

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



        holder.imgmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);

                View bottomsheetview = LayoutInflater.from(context).inflate(R.layout.bottomsheet_details,holder.bslinearlayout);

                bottomsheetview.findViewById(R.id.bs_llunfollow).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llblock).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llmsguser).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llproposal).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llreport).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llrequest).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();
                    }
                });

                bottomsheetview.findViewById(R.id.bs_llshare).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Item "+postSuitcaseArrayList.get(position).ps_name+" Blocked", Toast.LENGTH_SHORT).show();

                    }
                });

                bottomSheetDialog.setContentView(bottomsheetview);
                bottomSheetDialog.show();

            }
        });

        holder.imgblacklike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Drawable drawable1 =  holder.imgblacklike.getDrawable();
                Drawable drawable2 = context.getResources().getDrawable(R.drawable.redhearticon);


                if (drawable1.equals(drawable2)){
                    holder.imgblacklike.setImageResource(R.drawable.redhearticon);
                }else {
                    holder.imgblacklike.setImageResource(R.drawable.likeblackicon);
                }

//                heart.toggleLike();

            }
        });

       /* holder.imgredlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                heart.toggleLike();
            }
        });
*/
/*
        holder.imgredlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgblacklike.setVisibility(View.VISIBLE);
                holder.imgredlike.setVisibility(View.GONE);}
        });
*/
/*

        holder.imgblacklike.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context, postSuitcaseArrayList.get(position).ps_name, Toast.LENGTH_SHORT).show();
                return gestureDetector.onTouchEvent(event);
            }
        });

        holder.imgredlike.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(context, postSuitcaseArrayList.get(position).ps_name, Toast.LENGTH_SHORT).show();
                return gestureDetector.onTouchEvent(event);
            }
        });
*/


    }

    @Override
    public int getItemCount() {
        return postSuitcaseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout bslinearlayout;

        ImageView imgprofile,imgpost,imgmenu,imgblacklike,imgredlike,imgcomment,imgshare,imgbookmark;
        TextView txtprofilename,txtlocation,txttime,txtlikes,txtcomments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            bslinearlayout = itemView.findViewById(R.id.bs_linearlayout);

            imgprofile = itemView.findViewById(R.id.post_imgprofile);
            imgpost = itemView.findViewById(R.id.post_imgpost);
            imgmenu = itemView.findViewById(R.id.post_imgmenu);
            imgblacklike = itemView.findViewById(R.id.post_imgblackheartlike);
//            imgredlike = itemView.findViewById(R.id.post_imgblueheartlike);
            imgcomment = itemView.findViewById(R.id.post_imgcomment);
            imgshare = itemView.findViewById(R.id.post_imgshare);
            imgbookmark = itemView.findViewById(R.id.post_imgbookmark);
            txtprofilename = itemView.findViewById(R.id.post_txtname);
            txtlocation = itemView.findViewById(R.id.post_txtlocation);
            txttime = itemView.findViewById(R.id.post_txttime);
            txtlikes = itemView.findViewById(R.id.post_txtlikes);
            txtcomments = itemView.findViewById(R.id.post_txtcomments);
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
