package com.t3h.newsproject;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(R.layout.activity_webview);
        initView();
    }

    private void initView() {
        webView = findViewById(R.id.web_view);
        Intent intent = getIntent();
        url = intent.getStringExtra(Const.EXTRA_URL);
        webView.loadUrl(url);
    }

}
