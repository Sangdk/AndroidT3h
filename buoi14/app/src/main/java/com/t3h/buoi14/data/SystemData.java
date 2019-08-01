package com.t3h.buoi14.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.t3h.buoi14.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public List<Song> getData() {
        List<Song> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
        while (cursor.isAfterLast() == false) {
//            for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.e(cursor.getColumnName(i) + "--", cursor.getString(i) + "");
//            }
//            Log.e("--------------------", "--------------");
            String data = cursor.getString(indexData);
            String title = cursor.getString(indexTitle);
            String artist = cursor.getString(indexArtist);
            String album = cursor.getString(indexAlbum);
            int size = cursor.getInt(indexSize);
            int duration = cursor.getInt(indexDuration);
            Song song = new Song(title, artist, album, duration, data, size);
            arr.add(song);
            cursor.moveToNext();
        }
        return arr;
    }
}
