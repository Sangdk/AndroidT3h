package com.t3h.buoi7;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_alpha, btn_rotate, btn_translate, btn_scale, btn_set;
    private ImageView imLauncher;
    private Animation alpha, rotate, translate, scale, set;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
    }

    private void initView() {
        btn_alpha = findViewById(R.id.btn_alpha);
        btn_translate = findViewById(R.id.btn_translate);
        btn_rotate = findViewById(R.id.btn_rotate);
        btn_scale = findViewById(R.id.btn_scale);
        btn_set = findViewById(R.id.btn_set);
        imLauncher = findViewById(R.id.im_launcher);

        alpha = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
        scale = AnimationUtils.loadAnimation(this,R.anim.scale_anim);
        translate = AnimationUtils.loadAnimation(this,R.anim.traslate_anim);
        set = AnimationUtils.loadAnimation(this,R.anim.set_anim);


        btn_alpha.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha:
                imLauncher.startAnimation(alpha);
                break;
            case R.id.btn_translate:
                imLauncher.startAnimation(translate);
                break;
            case R.id.btn_rotate:
                imLauncher.startAnimation(rotate);
                break;
            case R.id.btn_scale:
                imLauncher.startAnimation(scale);
                break;
            case R.id.btn_set:
                imLauncher.startAnimation(set);
                break;
        }

    }
}
