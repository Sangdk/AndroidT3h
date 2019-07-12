package com.t3h.newsproject.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.newsproject.MainActivity;
import com.t3h.newsproject.R;

public class FavoriteFragment extends BaseFragment<MainActivity> {
    private TextView txtFavorite;
    private RecyclerView recyclerFavorite;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtFavorite = findViewById(R.id.txt_favorite);
        recyclerFavorite = findViewById(R.id.recycler_favorite);
    }
}
