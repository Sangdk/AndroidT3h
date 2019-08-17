package com.t3h.mp3music.model;

import android.provider.MediaStore;

public class Artist extends BaseModel {
    @FieldInfo(fieldName = MediaStore.Audio.Artists.ARTIST)
    private String name;
    @FieldInfo(fieldName = MediaStore.Audio.Artists.NUMBER_OF_ALBUMS)
    private int numberOfAlbum;
    @FieldInfo(fieldName = MediaStore.Audio.Artists.NUMBER_OF_TRACKS)
    private int numberOfTracks;

    public String getName() {
        return name;
    }

    public int getNumberOfAlbum() {
        return numberOfAlbum;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }
}
