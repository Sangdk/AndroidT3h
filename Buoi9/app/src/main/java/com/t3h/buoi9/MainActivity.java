package com.t3h.buoi9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Runnable {
    public static final int WHAT_NEWS =1;
    private RecyclerView recyclerViewNews;
    private NewsAdapter adapter;
    private ArrayList<News> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Thread t = new Thread(this);
        t.start();

    }

    private void initView() {
        recyclerViewNews = findViewById(R.id.recycler_news);
        adapter = new NewsAdapter(this);
        recyclerViewNews.setAdapter(adapter);
    }

    @Override
    public void run() {
        String url = "https://www.24h.com.vn/upload/rss/bongda.rss";
        XMLParse parse = new XMLParse(url);
        ArrayList<News> arr = parse.getArr();

        Message msg = new Message();
        msg.obj =arr;
        msg.what = WHAT_NEWS;
        handler.sendMessage(msg);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == WHAT_NEWS){
                data = (ArrayList<News>) msg.obj;
                adapter.setData(data);
            }
        }
    };
}
