package com.t3h.buoi14.model;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;
    private String data;
    private int size;

    public Song(String title, String artist, String album, int duration, String data, int size) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.data = data;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public String getData() {
        return data;
    }

    public int getSize() {
        return size;
    }
}
