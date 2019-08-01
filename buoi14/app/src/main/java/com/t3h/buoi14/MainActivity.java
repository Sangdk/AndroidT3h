package com.t3h.buoi14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.t3h.buoi14.data.MediaManager;
import com.t3h.buoi14.data.SystemData;
import com.t3h.buoi14.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SongAdapter.ItemSOngClickListener {
    private SystemData data;
    private SongAdapter adapter;
    private ActivityMainBinding binding;
    private MediaManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
//        initData();
    }

    private void initView() {
        data = new SystemData(this);
        adapter = new SongAdapter(this);
        adapter.setData(data.getData());
        binding.recycler.setAdapter(adapter);
        adapter.setListener(this);
        manager = new MediaManager(data.getData(), this);
    }

    private void initData() {
        data = new SystemData(this);
        data.getData();
    }

    @Override
    public void onItemSongClick(int position) {
        manager.create(position);
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }
}
