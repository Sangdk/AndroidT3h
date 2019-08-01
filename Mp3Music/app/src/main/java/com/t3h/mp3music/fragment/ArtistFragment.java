package com.t3h.mp3music.fragment;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentArtistBinding;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    public String getTitle() {
        return "Artist";
    }
}
