package com.t3h.buoi14.data;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import com.t3h.buoi14.model.Song;

import java.util.List;
import java.util.Random;

public class MediaManager implements MediaPlayer.OnCompletionListener {
    private List<Song> data;
    private MediaPlayer player;
    private Context context;

    public MediaManager(List<Song> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void create(int position) {
        release();
        Uri uri = Uri.parse(data.get(position).getData());
        player = MediaPlayer.create(context, uri);
        start();
        player.setOnCompletionListener(this);
    }

    public void start() {
        if (player != null) {
            player.start();
        }
    }

    public void stop() {
        if (player != null) {
            player.stop();
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void release() {
        if (player != null) {
            player.release();
        }
    }

    public int getDuration() {
        return player == null ? 0 : player.getDuration();
    }

    public int getCurrentPosition() {
        return player == null ? 0 : player.getCurrentPosition();
    }

    public void seek(int position) {
        if (player != null) {
            player.seekTo(position);
        }
    }

    public void loop(boolean isLooping) {
        if (player != null) {
            player.setLooping(isLooping);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Random rd = new Random();
        int position = rd.nextInt(data.size());
        create(position);
    }
}
