package com.example.view_move_in;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


      //      自定义动画
    private RelativeLayout mRl;
    private ImageView mIvCab;
    private ImageView mIvJunkOk;
    private ImageView mIvBin;

    private boolean mInvisToVis = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect rect = new Rect();
                mRl.getHitRect(rect);
                final float centerX = rect.centerX();
                final float centerY = rect.centerY();
                FlipAnimation flipAnimation = new FlipAnimation(0.0F, 90.0F, centerX, centerY, true);
                flipAnimation.setDuration(600L);
                flipAnimation.setInterpolator(new AccelerateInterpolator());
                flipAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public final void onAnimationStart(Animation paramAnonymousAnimation) {
                    }

                    @Override
                    public final void onAnimationEnd(Animation paramAnonymousAnimation) {
                        if (mInvisToVis) {
                            mIvJunkOk.setVisibility(View.VISIBLE);
                            mIvCab.setVisibility(View.INVISIBLE);
                            mIvBin.setVisibility(View.INVISIBLE);
                        } else {
                            mIvJunkOk.setVisibility(View.INVISIBLE);
                            mIvCab.setVisibility(View.VISIBLE);
                            mIvBin.setVisibility(View.VISIBLE);
                        }
                        mInvisToVis = !mInvisToVis;
                        FlipAnimation localb = new FlipAnimation(270.0F, 360.0F, centerX, centerY, false);
                        localb.setDuration(600L);
                        localb.setFillAfter(true);
                        localb.setInterpolator(new DecelerateInterpolator());
                        localb.setAnimationListener(null);
                        mRl.startAnimation(localb);
                    }
                    @Override
                    public final void onAnimationRepeat(Animation paramAnonymousAnimation) {
                    }
                });
                mRl.startAnimation(flipAnimation);
            }
        });
    }

    private void initViews() {
        mRl = (RelativeLayout) findViewById(R.id.rl);
        mIvCab = (ImageView) findViewById(R.id.cab);
        mIvJunkOk = (ImageView) findViewById(R.id.junk_ok);
        mIvBin = (ImageView) findViewById(R.id.bin);
    }

//    private TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView = findViewById(R.id.textview);
//        textView.setBackgroundResource(R.drawable.frame_layout);
//        AnimationDrawable drawable = (AnimationDrawable) textView.getBackground();
//        drawable.start();
//    }
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Animation animatable= AnimationUtils.loadAnimation(MainActivity.this,R.anim.view_anim);
//                animatable.setDuration(300);
//                animatable.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//                    }
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                    }
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//                    }
//                });
//                textView.startAnimation(animatable);
//            }
//        });


}