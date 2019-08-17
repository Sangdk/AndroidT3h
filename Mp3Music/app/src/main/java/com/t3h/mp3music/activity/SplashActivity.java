package com.t3h.mp3music.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.t3h.mp3music.R;

public class SplashActivity extends Activity {
    private final int ANIM_DISPLAY_LENGTH = 1000 ;
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private ImageView img;
    private Animation anim_fadin;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_screen);
        initView();

        /* New Handler to start the Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void initView() {
        img = findViewById(R.id.txt_splash_screen);
        img.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img.setVisibility(View.VISIBLE);
                anim_fadin = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.anim_fadein);
                img.startAnimation(anim_fadin);
            }
        }, ANIM_DISPLAY_LENGTH);
    }
}
