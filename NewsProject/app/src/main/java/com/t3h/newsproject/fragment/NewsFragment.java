package com.t3h.newsproject.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.newsproject.MainActivity;
import com.t3h.newsproject.R;
import com.t3h.newsproject.api.ApiBuilder;
import com.t3h.newsproject.dao.AppDatabase;
import com.t3h.newsproject.model.News;
import com.t3h.newsproject.model.NewsAdapter;
import com.t3h.newsproject.model.NewsResponsive;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends BaseFragment<MainActivity> implements Callback<NewsResponsive>, SearchView.OnQueryTextListener, NewsAdapter.ItemClickListener {
    private RecyclerView recyclerNews;
    private NewsAdapter adapter;
    private String keySearch;
    private String TAG = "NewsFragment";
    private SearchView searchView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerNews = findViewById(R.id.recycler_news);
        adapter = new NewsAdapter(getContext());
        recyclerNews.setAdapter(adapter);
        adapter.setItemClickListener(this);
        setHasOptionsMenu(true);
        initData();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        MenuItem item = menu.findItem(R.id.search_bar);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void initData() {
        if (keySearch != null) {
            String apiKey = "8921d0b0544848a9b059d19e8a93b71b";
            String language = "vi";
            ApiBuilder.getInstance().getNews(keySearch, apiKey, language).enqueue(this);
            Log.d(TAG, "not null");
        } else {
            keySearch = "ronaldo";
            String apiKey = "8921d0b0544848a9b059d19e8a93b71b";
            String language = "vi";
            Log.d(TAG, "null");
            ApiBuilder.getInstance().getNews(keySearch, apiKey, language).enqueue(this);
        }
    }

    @Override
    public void onResponse(Call<NewsResponsive> call, Response<NewsResponsive> response) {
        List<News> news = response.body().getNews();
        News[] arr = new News[news.size()];
        news.toArray(arr);
        Log.d(TAG, "response " + arr.length);
        adapter.setData(Arrays.asList(arr));
    }

    @Override
    public void onFailure(Call<NewsResponsive> call, Throwable t) {

    }

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

    @Override
    public void onItemClickListener(int position) {
    }

    @Override
    public void onItemLongClickListener(int position) {
        News item = adapter.getData().get(position);
        AppDatabase.getInstance(getContext()).getNewsDao().insert(item);
        Toast.makeText(getContext(), "Tin đã lưu", Toast.LENGTH_SHORT).show();

    }
}
