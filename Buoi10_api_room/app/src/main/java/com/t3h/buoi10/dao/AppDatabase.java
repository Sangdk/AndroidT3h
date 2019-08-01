package com.t3h.buoi10.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.t3h.buoi10.model.News;

@Database(entities = News.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "news-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public abstract NewsDao getNewsDao();
}
