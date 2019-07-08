package com.t3h.buoi10.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t3h.buoi10.model.News;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news WHERE id = :Id")
    News getNewsFromId(long Id);

    @Insert
    void insertAll(News... news);

    @Delete
    void delete(News... news);

    @Update
    void update(News... news);

    @Query("DELETE FROM news")
    void deleteAll();
}
