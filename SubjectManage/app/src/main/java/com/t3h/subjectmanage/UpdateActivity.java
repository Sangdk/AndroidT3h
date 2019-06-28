package com.t3h.subjectmanage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtSubject, edtScore;
    Button btnUpdate, btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initView();
    }

    private void initView() {
        edtName = findViewById(R.id.edit_name);
        edtScore = findViewById(R.id.edit_score);
        edtSubject = findViewById(R.id.edit_subject);
        btnUpdate = findViewById(R.id.button_update);
        btnCancel = findViewById(R.id.button_cancel);

        btnUpdate.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_update:
                break;
            case R.id.button_cancel:
                finish();
                break;
        }
    }
}
