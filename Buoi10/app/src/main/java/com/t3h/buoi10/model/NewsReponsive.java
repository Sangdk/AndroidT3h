package com.t3h.buoi10.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsReponsive {

    @SerializedName("articles")
    private ArrayList<News> news;

    public ArrayList<News> getNews() {
        return news;
    }
}
