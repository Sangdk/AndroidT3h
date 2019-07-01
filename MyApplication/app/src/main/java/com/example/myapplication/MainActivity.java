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

    private Button btnStart;
    private Button btnStop;
    private TextView tvTimer;
    private CountDownTimer cdt;
    private Time t = new Time(0, 0, 0, 0);

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

        tvTimer.setText(t.show());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                checkTime();
                btnStart.setClickable(false);
                btnStop.setClickable(true);
                break;
            case R.id.btnStop:
                btnStop.setClickable(false);
                btnStart.setClickable(true);
                cdt.cancel();
                Toast.makeText(this, t.show(), Toast.LENGTH_LONG).show();
                reset();
                break;

        }
    }

    public void checkTime() {
        cdt = new CountDownTimer(1000, 10) {
            @Override
            public void onTick(long l) {
                t.setMsText(t.getMsText() + 1);
                if (t.getMsText() == 100) {
                    t.setScText(t.getScText() + 1);
                    t.setMsText(0);
                }
                if (t.getScText() == 60) {
                    t.setMinText(t.getMinText() + 1);
                    t.setScText(0);
                }
                if (t.getMinText() == 60) {
                    t.setHourText(t.getHourText() + 1);
                    t.setMinText(0);
                }
                tvTimer.setText(t.show());
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        cdt.start();
    }

    public void reset() {
        t.setMinText(0);
        t.setMsText(0);
        t.setScText(0);
        t.setHourText(0);
    }

}
