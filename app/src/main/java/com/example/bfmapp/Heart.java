package com.example.bfmapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class Heart {

    ImageView imgwhite,imgblue;
    int position;

    DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();

    public Heart(ImageView imgwhite, ImageView imgblue,int position) {
        this.position = position;
        this.imgwhite = imgwhite;
        this.imgblue = imgblue;
    }


    public void toggleLike(){

        AnimatorSet animatorSet = new AnimatorSet();


        if (imgblue.getVisibility() ==  View.VISIBLE){
            imgblue.setScaleX(0.1f);
            imgblue.setScaleY(0.1f);

            ObjectAnimator scaledownY = ObjectAnimator.ofFloat(imgblue,"scaleY",1f,0f);
            scaledownY.setDuration(300);
            scaledownY.setInterpolator(accelerateInterpolator);

            ObjectAnimator scaledownX = ObjectAnimator.ofFloat(imgblue,"scaleX",1f,0f);
            scaledownX.setDuration(300);
            scaledownX.setInterpolator(accelerateInterpolator);

            imgblue.setVisibility(View.GONE);
            imgwhite.setVisibility(View.VISIBLE);

            animatorSet.playTogether(scaledownY,scaledownX);
        }

        else if (imgblue.getVisibility() ==  View.GONE){
            imgblue.setScaleX(0.1f);
            imgblue.setScaleY(0.1f);

            ObjectAnimator scaledownY = ObjectAnimator.ofFloat(imgblue,"scaleY",0.1f,1f);
            scaledownY.setDuration(300);
            scaledownY.setInterpolator(decelerateInterpolator);

            ObjectAnimator scaledownX = ObjectAnimator.ofFloat(imgblue,"scaleX",0.1f,1f);
            scaledownX.setDuration(300);
            scaledownX.setInterpolator(decelerateInterpolator);

            imgblue.setVisibility(View.VISIBLE);
            imgwhite.setVisibility(View.GONE);

            animatorSet.playTogether(scaledownY,scaledownX);
        }

        animatorSet.start();
    }
}
