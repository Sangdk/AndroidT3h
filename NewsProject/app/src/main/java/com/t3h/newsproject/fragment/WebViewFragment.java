package com.t3h.newsproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.t3h.newsproject.MainActivity;
import com.t3h.newsproject.R;

public class WebViewFragment extends BaseFragment<MainActivity> {
    private WebView webView;
    private String url;

    public WebViewFragment(String url) {
        this.url = url;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_webview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView = findViewById(R.id.webview);
        if (url != null) {
            webView.loadUrl(url);
        } else {
            Toast.makeText(getContext(), "Can't load website", Toast.LENGTH_SHORT);
        }
        Log.d("WebViewFragment", "created");
    }
}
