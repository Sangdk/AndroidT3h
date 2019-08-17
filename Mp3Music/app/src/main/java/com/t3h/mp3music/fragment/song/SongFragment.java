package com.t3h.mp3music.fragment.song;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.t3h.mp3music.R;
import com.t3h.mp3music.activity.MainActivity;
import com.t3h.mp3music.activity.PlaySongActivity;
import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentSongBinding;
import com.t3h.mp3music.model.Song;
import com.t3h.mp3music.utils.SystemDataUtils;

import java.util.ArrayList;

import static android.widget.LinearLayout.HORIZONTAL;

public class SongFragment extends BaseFragment<FragmentSongBinding> implements SongItemListener {
    private SystemDataUtils dataUtils;
    private BaseAdapter<Song> adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataUtils = new SystemDataUtils(getContext());
        adapter = new BaseAdapter<>(getContext(), R.layout.item_song);
        adapter.setData(dataUtils.getSong());
        adapter.setListener(this);
        binding.recyclerSong.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public String getTitle() {
        return "Song";
    }

    @Override
    public void onSongClick(Song song) {
        Intent intent = new Intent(getActivity(), PlaySongActivity.class);
        startActivity(intent);
    }
}
