package com.example.daoduythang_asm_assignment;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FeedBackEntity.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract FeedBackDao feedBackDao();

    public static AppDatabase getAppDatabase(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class,"News").allowMainThreadQueries().build();
        }
        return appDatabase;
    }



}
