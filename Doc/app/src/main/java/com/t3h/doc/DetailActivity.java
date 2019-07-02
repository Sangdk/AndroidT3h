package com.t3h.doc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    CircleImageView imgDetail;
    TextView txtName, txtAuthor, txtCategory, txtStatus, txtPubDate, txtDetail;
    ImageButton btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
    }

    private void initView() {
        imgDetail = findViewById(R.id.img_detail);
        txtName = findViewById(R.id.txt_name);
        txtAuthor = findViewById(R.id.txt_author);
        txtCategory = findViewById(R.id.txt_category);
        txtStatus = findViewById(R.id.txt_status);
        txtPubDate = findViewById(R.id.txt_pub_date);
        txtDetail = findViewById(R.id.txt_detail);
        btnBack = findViewById(R.id.btn_back);

        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra(Const.EXTRA_BUNDLE);
        String name = bundle.getString(Const.EXTRA_NAME);
        String author = bundle.getString(Const.EXTRA_AUTHOR);
        String status = bundle.getString(Const.EXTRA_STATUS);
        String detail = bundle.getString(Const.EXTRA_DETAIL);
        int img = bundle.getInt(Const.EXTRA_IMAGE);

        imgDetail.setImageResource(img);
        txtName.setText(name);
        txtStatus.setText(status);
        StringBuffer sb = new StringBuffer();
        sb.append("Tac gia: ");
        sb.append(author);
        String authorReal = sb.toString();
        txtAuthor.setText(authorReal);
        txtDetail.setText(detail);

        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
