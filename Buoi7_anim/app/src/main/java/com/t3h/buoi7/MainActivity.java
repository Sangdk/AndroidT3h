package com.t3h.buoi7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSt;
    private ImageView ivAni;
    private AnimationDrawable anis;
    private ImageView imLevel;
    private LevelListDrawable level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnSt = findViewById(R.id.btn_start);
        ivAni = findViewById(R.id.im_anim);
        anis = (AnimationDrawable) ivAni.getDrawable();
        imLevel = findViewById(R.id.iv_level);
        level = (LevelListDrawable) imLevel.getDrawable();

        btnSt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if (anis.isRunning()){
//            anis.stop();
//        }else {
//            anis.start();
//        }

        boolean changed = level.setLevel(level.getLevel()+1);
        if (!changed){
            level.setLevel(0);
        }
    }
}
