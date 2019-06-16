package com.t3h.puzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnPlay;
    EditText edtPlayerName;
    public static final int REQUEST_PLAY =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnPlay = findViewById(R.id.btnPlay);
        edtPlayerName = findViewById(R.id.edtPlayerName);

        btnPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String playerName = edtPlayerName.getText().toString();
        if (playerName.isEmpty()){
            Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this,PlayActivity.class);
//            intent.putExtra()
            startActivityForResult(intent,REQUEST_PLAY);
        }
    }
}
