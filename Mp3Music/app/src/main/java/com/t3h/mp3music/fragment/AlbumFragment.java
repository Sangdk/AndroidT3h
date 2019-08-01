package com.t3h.mp3music.fragment;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentAlbumsBinding;

public class AlbumFragment extends BaseFragment<FragmentAlbumsBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_albums;
    }

    @Override
    public String getTitle() {
        return "Albums";
    }
}
