package com.example.th_lab_06_b;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {product.class}, version = 1)
public abstract class DataBaseP extends RoomDatabase {
    private static DataBaseP dataBaseP;
    public synchronized static DataBaseP getInstance(Context context){
        if (dataBaseP == null){
            dataBaseP = Room.databaseBuilder(context.getApplicationContext(),DataBaseP.class, "Place_2").allowMainThreadQueries().build();
        }
        return dataBaseP;
    }
    public abstract ProductDao pDao();
}
