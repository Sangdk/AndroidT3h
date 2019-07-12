package com.t3h.newsproject.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.t3h.newsproject.model.News;

@Database(entities = News.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context contex) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(contex,
                    AppDatabase.class,
                    "news-Database")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
    public abstract NewsDao getNewsDao();
}
