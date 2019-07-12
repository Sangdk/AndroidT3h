package com.t3h.newsproject.fragment;

import android.os.Bundle;

import android.view.MenuItem;

import android.widget.PopupMenu;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.newsproject.MainActivity;
import com.t3h.newsproject.R;
import com.t3h.newsproject.dao.AppDatabase;
import com.t3h.newsproject.model.News;
import com.t3h.newsproject.model.NewsAdapter;

import java.lang.reflect.Array;
import java.util.List;

public class SaveFragment extends BaseFragment<MainActivity> implements NewsAdapter.ItemClickListener, PopupMenu.OnMenuItemClickListener {
    private TextView txtSave;
    private RecyclerView recyclerSave;
    private NewsAdapter adapter;
    private int position;
    private List<News> arr;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_saved;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        arr = AppDatabase.getInstance(getContext()).getNewsDao().getAll();
        adapter.setData(arr);
        setText();
    }

    private void setText() {
        StringBuffer txt = new StringBuffer();
        txt.append("Tin đã lưu: ");
        txt.append(arr.size());
        txt.append(" Tin");
        txtSave.setText(txt.toString());
    }

    private void initView() {
        txtSave = findViewById(R.id.txt_save);
        recyclerSave = findViewById(R.id.recycler_saved);

        adapter = new NewsAdapter(getContext());
        recyclerSave.setAdapter(adapter);
        adapter.setItemClickListener(this);
    }

    @Override
    public void onItemClickListener(int position) {
    }

    @Override
    public void onItemLongClickListener(int position) {
        this.position = position;
        PopupMenu popup = new PopupMenu(getContext(), getView());
        popup.inflate(R.menu.context_menu);
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_like:
                break;
            case R.id.it_delete:
                arr.remove(position);
                adapter.notifyItemRemoved(position);
                adapter.notifyItemRangeChanged(position, arr.size());
                setText();

                News[] news = new News[arr.size()];
                arr.toArray(news);
                AppDatabase.getInstance(getContext()).getNewsDao().deleteAll();
                AppDatabase.getInstance(getContext()).getNewsDao().insertAll(news);
                break;
        }
        return false;
    }
}
