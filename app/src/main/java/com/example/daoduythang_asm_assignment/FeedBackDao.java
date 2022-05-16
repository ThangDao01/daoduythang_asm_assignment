package com.example.daoduythang_asm_assignment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface FeedBackDao {
    @Insert()
    void insertFeedBack(FeedBackEntity FeedBack);

    @Update()
    void updateFeedBack(FeedBackEntity FeedBack);

    @Delete()
    void deleteFeedBack(FeedBackEntity FeedBack);

    @Query("SELECT * FROM FeedBack")
    List<FeedBackEntity> getAllFeedBack();

    @Query("SELECT * FROM FeedBack WHERE id = :id")
    FeedBackEntity getAllFeedBack(int id);

    @Query("DELETE FROM FeedBack")
    void deleteAll();

    @Query("SELECT COUNT('id')  FROM FeedBack")
    Integer countTotalRecord();
}
