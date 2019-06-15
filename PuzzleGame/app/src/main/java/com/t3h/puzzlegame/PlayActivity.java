package com.t3h.puzzlegame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {


    CountDownTimer cdt;

    TextView tvScore, tvTime, tvQuestion;

    ImageButton btnTrue, btnFalse;

    private boolean flag;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        initView();
    }

    private void initView() {

        tvScore = findViewById(R.id.tvScore);
        tvTime = findViewById(R.id.tvTime);
        tvQuestion = findViewById(R.id.tvQuestion);

        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);

        tvScore.setText("0");
        tvTime.setText("5");
        checkTime();
        initQuestion();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTrue:
                if (flag) {
                    tvTime.setText("5");
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    setScore();
                    initQuestion();
                } else {
                    btnTrue.setVisibility(btnTrue.GONE);
                    btnFalse.setVisibility(btnFalse.GONE);
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
                    cdt.cancel();
                    tvTime.setText("0");
                    Toast.makeText(PlayActivity.this, "Game over",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnFalse:
                if (!flag) {
                    tvTime.setText("5");
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                    setScore();
                    initQuestion();
                } else {
                    btnTrue.setVisibility(btnTrue.GONE);
                    btnFalse.setVisibility(btnFalse.GONE);
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
                    cdt.cancel();
                    tvTime.setText("0");
                    Toast.makeText(PlayActivity.this, "Game over",
                            Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    public void setScore() {
            int current = Integer.parseInt(tvScore.getText().toString());
            tvScore.setText(current + 1 + "");
    }

    public void initQuestion() {
        int max = 10;
        Random rd = new Random();
        int nb1 = rd.nextInt(max) + 1;
        int nb2 = rd.nextInt(max) + 1;
        int as;
        if (nb1 % 2 == 0) {
            as = nb1 + nb2;
            tvQuestion.setText(nb1 + " + " + nb2 + " = " + as);
            flag = true;
        } else {
            as = nb1 + nb2 + rd.nextInt(3)+1;
            tvQuestion.setText(nb1 + " + " + nb2 + " = " + as);
            flag =false;
        }
    }

    public void checkTime() {
        cdt = new CountDownTimer(5000000, 1000) {
            @Override
            public void onTick(long l) {
                int current = Integer.parseInt(tvTime.getText().toString());
                tvTime.setText(current - 1 + "");
                if( Integer.parseInt(tvTime.getText().toString()) == 0 ) {
                    Toast.makeText(PlayActivity.this, "Game over",
                            Toast.LENGTH_SHORT).show();
                    btnTrue.setVisibility(btnTrue.GONE);
                    btnFalse.setVisibility(btnFalse.GONE);
                    cdt.cancel();
                }
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        cdt.start();

    }
}
