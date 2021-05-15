package com.example.th_lab_06_b;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class product {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "visit")
    String place;

    @Override
    public String toString() {
        return place;
    }
}
