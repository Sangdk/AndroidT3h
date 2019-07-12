package com.t3h.newsproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t3h.newsproject.model.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE id = :id")
    News getNewsFromId(long id);


    @Insert
    void insert(News item);

    @Insert
    void insertAll(News... news);

    @Delete
    void delete(News... news);

    @Query("DELETE FROM news")
    void deleteAll();

    @Update
    void update(News... news);
}
