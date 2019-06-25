package com.example.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart;
    Button btnStop;
    TextView tvTimer;
    long msText = 0;
    long scText = 0;
    long minText = 0;
    long hourText = 0;
    CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        tvTimer = findViewById(R.id.tvTimer);
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                checkTime();
                break;
            case R.id.btnStop:
                cdt.cancel();
                String timeResult = hourText + " :" + minText + " :" + scText + " :" + msText;
                Toast.makeText(this, timeResult, Toast.LENGTH_SHORT).show();
                msText = 0;
                scText = 0;
                minText = 0;
                hourText = 0;
                setTextView();
                break;

        }
    }

    public void checkTime() {
        cdt = new CountDownTimer(500000000, 10) {
            @Override
            public void onTick(long l) {
                msText += 1;
                if( msText == 100) {
                    scText += 1;
                    msText = 0;
                }
                if( scText == 60) {
                    minText += 1;
                    scText = 0;
                }
                if( minText == 60) {
                    hourText += 1;
                    minText = 0;
                }
                setTextView();
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        cdt.start();

    }

    public void setTextView() {
        String timeResult = hourText + " :" + minText + " :" + scText + " :" + msText;
        tvTimer.setText( timeResult );
    }
}
