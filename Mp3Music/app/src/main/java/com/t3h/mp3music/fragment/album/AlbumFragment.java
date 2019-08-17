package com.t3h.mp3music.fragment.album;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.activity.MainActivity;
import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentAlbumsBinding;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.utils.SystemDataUtils;

import java.util.ArrayList;

public class AlbumFragment extends BaseFragment<FragmentAlbumsBinding> implements AlbumItemListener {
    private BaseAdapter<Album> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_albums;
    }

    @Override
    public String getTitle() {
        return "Albums";
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter<>(getContext(), R.layout.item_album);
        dataUtils = new SystemDataUtils(getContext());
        adapter.setData(dataUtils.getAlbum());
        adapter.setListener(this);
        binding.recyclerAlbums.setAdapter(adapter);
    }

    @Override
    public void onAlbumItemClick(Album album) {
        String albumID = album.getAlbumID();
        MainActivity main = (MainActivity) getActivity();
        main.addFragmentAlbumDetail(albumID);
    }
}
