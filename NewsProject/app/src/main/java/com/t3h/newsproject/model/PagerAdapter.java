package com.t3h.newsproject.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.t3h.newsproject.fragment.FavoriteFragment;
import com.t3h.newsproject.fragment.NewsFragment;
import com.t3h.newsproject.fragment.SaveFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new NewsFragment();
                break;
            case 1:
                frag = new FavoriteFragment();
                break;
            case 2:
                frag = new SaveFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Tin tức";
                break;
            case 1:
                title = "Tin đã thích";
                break;
            case 2:
                title = "Tin đã lưu";
                break;
        }
        return title;
    }
}
