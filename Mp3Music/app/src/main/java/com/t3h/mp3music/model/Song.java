package com.t3h.mp3music.model;

import android.provider.MediaStore;

public class Song extends BaseModel {
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.DATA)
    private String data;
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.TITLE)
    private String title;
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.SIZE)
    private int size;
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.DURATION)
    private int duration;
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.ARTIST)
    private String artist;
    @FieldInfo(fieldName = MediaStore.Audio.AudioColumns.ALBUM)
    private String album;

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
