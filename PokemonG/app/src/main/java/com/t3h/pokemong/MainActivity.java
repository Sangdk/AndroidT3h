package com.t3h.pokemong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    CheckBox cbMew, cbPika, cbDuck, cbSnor;
    SeekBar sbMew, sbPika, sbDuck, sbSnor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        cbMew = findViewById(R.id.cbMew);
        cbPika = findViewById(R.id.cbPikachu);
        cbDuck = findViewById(R.id.cbPsyduck);
        cbSnor = findViewById(R.id.cbSnorlax);

        sbMew = findViewById(R.id.mewth);
        sbPika = findViewById(R.id.pikachu);
        sbDuck = findViewById(R.id.psyduck);
        sbSnor = findViewById(R.id.snorlax);

        sbMew.setProgress(10);
        sbPika.setProgress(10);
        sbDuck.setProgress(10);
        sbSnor.setProgress(10);

    }
}
