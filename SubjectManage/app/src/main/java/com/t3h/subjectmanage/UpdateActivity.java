package com.t3h.subjectmanage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtSubject, edtScore;
    Button btnUpdate, btnCancel;
    public int position;

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

        Intent intent = getIntent();
        String name = intent.getStringExtra(Const.EXTRA_NAME);
        String subject = intent.getStringExtra(Const.EXTRA_SUBJECT);
        float score = intent.getFloatExtra(Const.EXTRA_SCORE, 0f);
        position = intent.getIntExtra("POSITION",0);

        edtName.setText(name);
        edtSubject.setText(subject);
        edtScore.setText(Float.toString(score));

        btnUpdate.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_update:
                String name = edtName.getText().toString();
                String subject = edtSubject.getText().toString();
                Float score = 0f;
                try {
                    score = Float.parseFloat(edtScore.getText().toString());
                } catch (Exception e) {
                    score = 0f;
                }

                if (name.isEmpty() || subject.isEmpty() || score == null) {
                    Toast.makeText(this, "Please import data", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(Const.EXTRA_NAME, name);
                intent.putExtra(Const.EXTRA_SUBJECT, subject);
                intent.putExtra(Const.EXTRA_SCORE, score);
                intent.putExtra("POSITION",position);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.button_cancel:
                finish();
                break;
        }
    }
}
