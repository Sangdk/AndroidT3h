package com.t3h.mp3music.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

import com.t3h.mp3music.R;
import com.t3h.mp3music.adapter.Mp3PagerAdapter;
import com.t3h.mp3music.base.BaseActivity;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.fragment.album.AlbumFragment;
import com.t3h.mp3music.fragment.album.AlbumDetailFragment;
import com.t3h.mp3music.fragment.artist.ArtistFragment;
import com.t3h.mp3music.fragment.song.SongFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements SearchView.OnQueryTextListener {

    private final String[] PERMISSION = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private SongFragment fmSong = new SongFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();
    private AlbumDetailFragment fmAlbumDetail = new AlbumDetailFragment();
    private Mp3PagerAdapter pagerAdapter;
    private SearchView searchView;

    @Override
    protected void intAct() {
        if (checkPermission() == false) {
            return;
        }

        getSupportActionBar().setElevation(0);
        pagerAdapter = new Mp3PagerAdapter(getSupportFragmentManager(), fmSong, fmArtist, fmAlbum);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSION) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(PERMISSION, 0);
                    return false;
                }
            }
        }
        return true;
    }

    public void addFragmentAlbumDetail(String albumID) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fmSong);
        transaction.hide(fmAlbum);
        transaction.hide(fmArtist);
        getSupportActionBar().hide();
        transaction.add(R.id.main, fmAlbumDetail);
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.addToBackStack("addFragmentAlbumDetail");
        transaction.commit();
        fmAlbumDetail.setData(albumID,this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            intAct();
        } else {
            finish();
        }
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
