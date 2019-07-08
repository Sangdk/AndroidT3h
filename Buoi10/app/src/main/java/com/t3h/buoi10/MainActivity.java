package com.t3h.buoi10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.t3h.buoi10.api.ApiBuilder;
import com.t3h.buoi10.dao.AppDatabase;
import com.t3h.buoi10.model.News;
import com.t3h.buoi10.model.NewsReponsive;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsReponsive> {
    private EditText edtSearch;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<News> arr = AppDatabase.getInstance(this)
                .getNewsDao().getAll();

        int a = arr.size();
    }

    private void initView() {
        edtSearch = findViewById(R.id.edt_search);
        btnSearch = findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String keySearch = edtSearch.getText().toString();
        String apiKey = "8921d0b0544848a9b059d19e8a93b71b";
        String language ="vi";

        ApiBuilder.getInstance().getNews(keySearch,apiKey,language).enqueue(this);

    }

    @Override
    public void onResponse(Call<NewsReponsive> call, Response<NewsReponsive> response) {
        News[] news = (News[]) response.body().getNews().toArray();
        AppDatabase.getInstance(this).getNewsDao().insertAll(news);
    }

    @Override
    public void onFailure(Call<NewsReponsive> call, Throwable t) {

    }
}
