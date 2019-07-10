package com.t3h.buoi10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.t3h.buoi10.api.ApiBuilder;
import com.t3h.buoi10.dao.AppDatabase;
import com.t3h.buoi10.model.News;
import com.t3h.buoi10.model.NewsAdapter;
import com.t3h.buoi10.model.NewsReponsive;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsReponsive>, Runnable {
    private EditText edtSearch;
    private Button btnSearch;
    private List<News> data;
    private RecyclerView recyclerViewNews;
    private NewsAdapter adapter;
    public static final int WHAT_NEWS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Thread t = new Thread(this);
        t.start();

    }

    private void initView() {
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);
        recyclerViewNews = findViewById(R.id.recycler_news);

        adapter = new NewsAdapter(this);
        btnSearch.setOnClickListener(this);
        recyclerViewNews.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        String keySearch = edtSearch.getText().toString();
        String apiKey = "8921d0b0544848a9b059d19e8a93b71b";
        String language = "vi";

        ApiBuilder.getInstance().getNews(keySearch, apiKey, language).enqueue(this);

    }

    @Override
    public void onResponse(Call<NewsReponsive> call, Response<NewsReponsive> response) {
//        News[] news = (News[]) response.body().getNews().toArray();
//        AppDatabase.getInstance(this).getNewsDao().insertAll(news);
        ArrayList<News> news = response.body().getNews();
        News[] arr = new News[news.size()];
        news.toArray(arr);

        AppDatabase.getInstance(this).getNewsDao()
                .insertAll(arr);

    }

    @Override
    public void onFailure(Call<NewsReponsive> call, Throwable t) {

    }

    @Override
    public void run() {
        data = AppDatabase.getInstance(this)
                .getNewsDao().getAll();
        Message msg = new Message();
        msg.obj = data;
        msg.what = WHAT_NEWS;
        handler.sendMessage(msg);

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == WHAT_NEWS) {
                data = (List<News>) msg.obj;
                adapter.setData(data);
            }
        }
    };
}
