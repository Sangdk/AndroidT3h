package com.t3h.magicbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName;
    Button btnStart;
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
    }

    private void initView() {
        edtName = findViewById(R.id.edtName);
        btnStart = findViewById(R.id.btnStart);
        tvResult = findViewById(R.id.tvResult);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = edtName.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Input Player Name first", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}