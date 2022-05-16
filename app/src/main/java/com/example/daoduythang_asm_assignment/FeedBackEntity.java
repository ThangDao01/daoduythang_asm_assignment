package com.example.daoduythang_asm_assignment;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FeedBack")

public class FeedBackEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "type")
    public String type;
    @ColumnInfo(name = "description")
    public String description;

}
