package com.t3h.newsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.t3h.newsproject.fragment.FavoriteFragment;
import com.t3h.newsproject.fragment.NewsFragment;
import com.t3h.newsproject.fragment.SaveFragment;
import com.t3h.newsproject.fragment.WebViewFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter adapter;
    private FavoriteFragment fmFavorite = new FavoriteFragment();
    private NewsFragment fmNews = new NewsFragment();
    private SaveFragment fmSaved = new SaveFragment();
    private WebViewFragment fmWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        adapter = new com.t3h.newsproject.model.PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(this);
    }

    public void showFragment(Fragment fmShow){
        Log.d("Main","showFragment");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fmFavorite);
        transaction.hide(fmNews);
        transaction.hide(fmSaved);

        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.show(fmShow);
        transaction.commit();
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

    public FavoriteFragment getFmFavorite() {
        return fmFavorite;
    }

    public NewsFragment getFmNews() {
        return fmNews;
    }

    public SaveFragment getFmSaved() {
        return fmSaved;
    }

    public WebViewFragment getFmWebView(String url) {
        fmWebView = new WebViewFragment(url);
        Log.d("main","getWeb View");
        return fmWebView;
    }
}
