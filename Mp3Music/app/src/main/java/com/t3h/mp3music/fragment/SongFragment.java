package com.t3h.mp3music.fragment;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentSongBinding;

public class SongFragment extends BaseFragment<FragmentSongBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public String getTitle() {
        return "Song";
    }
}
