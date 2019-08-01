package com.t3h.buoi10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.t3h.buoi10.api.ApiBuilder;
import com.t3h.buoi10.dao.AppDatabase;
import com.t3h.buoi10.model.News;
import com.t3h.buoi10.model.NewsAdapter;
import com.t3h.buoi10.model.NewsReponsive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<NewsReponsive>, SearchView.OnQueryTextListener {
    private MenuInflater inflater;
    private List<News> data;
    private RecyclerView recyclerViewNews;
    private NewsAdapter adapter;
    private SearchView searchView;
    public static final int WHAT_NEWS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        MenuItem item = menu.findItem(R.id.search_bar);
        searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Search here...");
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(false);

        return super.onCreateOptionsMenu(menu);
    }

    private void initView() {
        recyclerViewNews = findViewById(R.id.recycler_news);

        adapter = new NewsAdapter(this);
        recyclerViewNews.setAdapter(adapter);

    }

    @Override
    public void onResponse(Call<NewsReponsive> call, Response<NewsReponsive> response) {
//        News[] news = (News[]) response.body().getNews().toArray();
//        AppDatabase.getInstance(this).getNewsDao().insertAll(news);
        ArrayList<News> news = response.body().getNews();
        News[] arr = new News[news.size()];
        news.toArray(arr);

//        AppDatabase.getInstance(this).getNewsDao()
//                .insertAll(arr);
        adapter.setData(Arrays.asList(arr));
    }

    @Override
    public void onFailure(Call<NewsReponsive> call, Throwable t) {

    }

//    @Override
//    public void run() {
//        data = AppDatabase.getInstance(this)
//                .getNewsDao().getAll();
//        Message msg = new Message();
//        msg.obj = data;
//        msg.what = WHAT_NEWS;
//        handler.sendMessage(msg);
//
//    }
//
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == WHAT_NEWS) {
//                data = (List<News>) msg.obj;
//                adapter.setData(data);
//            }
//        }
//    };

    @Override
    public boolean onQueryTextSubmit(String query) {
        String keySearch = searchView.getQuery().toString();
        String apiKey = "8921d0b0544848a9b059d19e8a93b71b";
        String language = "vi";

        ApiBuilder.getInstance().getNews(keySearch, apiKey, language).enqueue(this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
