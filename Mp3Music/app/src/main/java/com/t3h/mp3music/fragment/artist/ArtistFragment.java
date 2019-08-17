package com.t3h.mp3music.fragment.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentArtistBinding;
import com.t3h.mp3music.fragment.album.AlbumItemListener;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.model.Artist;
import com.t3h.mp3music.utils.SystemDataUtils;

public class ArtistFragment extends BaseFragment<FragmentArtistBinding> implements ArtistItemListener {
    private BaseAdapter<Artist> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_artist;
    }

    @Override
    public String getTitle() {
        return "Artist";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_artist);
        dataUtils = new SystemDataUtils(getContext());
        adapter.setData(dataUtils.getArtists());
        adapter.setListener(this);
        binding.recyclerArtist.setAdapter(adapter);
    }

    @Override
    public void onArtistClick(Artist artist) {

    }
}
