package com.t3h.puzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnPlay;
    public static final int REQUEST_PLAY =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,PlayActivity.class);
        startActivityForResult(intent,REQUEST_PLAY);
    }
}
