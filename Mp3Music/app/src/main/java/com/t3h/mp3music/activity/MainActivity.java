package com.t3h.mp3music.activity;

import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.t3h.mp3music.R;
import com.t3h.mp3music.adapter.Mp3PagerAdapter;
import com.t3h.mp3music.base.BaseActivity;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.fragment.AlbumFragment;
import com.t3h.mp3music.fragment.ArtistFragment;
import com.t3h.mp3music.fragment.SongFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements SearchView.OnQueryTextListener {
    private SongFragment fmSong = new SongFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private Mp3PagerAdapter pagerAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void intAct() {
        pagerAdapter = new Mp3PagerAdapter(getSupportFragmentManager(), fmAlbum, fmArtist, fmSong);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        MenuItem itemSearch = menu.findItem(R.id.search_bar);
        searchView = (SearchView) itemSearch.getActionView();
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
