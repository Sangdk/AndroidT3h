package com.t3h.doc;

import androidx.annotation.DrawableRes;

public class Story {
    private String name;
    private String status;
    private String author;
    private String pubDate;
    private int image;

    public Story(@DrawableRes int image, String name, String status, String author, String pubDate) {
        this.name = name;
        this.status = status;
        this.author = author;
        this.pubDate = pubDate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {

        StringBuffer sb = new StringBuffer();

        sb.append(status);
        sb.append("-T/g: ");
        sb.append(author);
        String result = sb.toString();
        return result;
    }


    public String getPubDate() {
        return pubDate;
    }

    public int getImage() {
        return image;
    }
}
