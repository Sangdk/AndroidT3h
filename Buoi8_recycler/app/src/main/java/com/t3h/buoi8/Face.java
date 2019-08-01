package com.t3h.buoi8;

import androidx.annotation.DrawableRes;

public class Face {
    private int avatar;
    private String name;

    public Face(@DrawableRes int avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }
}
