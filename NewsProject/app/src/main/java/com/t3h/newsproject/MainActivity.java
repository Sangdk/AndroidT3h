package com.t3h.newsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.t3h.newsproject.fragment.FavoriteFragment;
import com.t3h.newsproject.fragment.NewsFragment;
import com.t3h.newsproject.fragment.SaveFragment;
import com.t3h.newsproject.model.PagerAdapterNews;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter adapter;
    private FavoriteFragment fmFavorite = new FavoriteFragment();
    private SaveFragment fmSave = new SaveFragment();
    private NewsFragment fmNews = new NewsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        adapter = new PagerAdapterNews(getSupportFragmentManager(),fmNews,fmSave,fmFavorite);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);
    }

    public FavoriteFragment getFmFavorite() {
        return fmFavorite;
    }

    public SaveFragment getFmSave() {
        return fmSave;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
