package com.t3h.magicbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
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
        btnStart  = findViewById(R.id.btnStart);
        tvResult = findViewById(R.id.tvResult);
    }
}
