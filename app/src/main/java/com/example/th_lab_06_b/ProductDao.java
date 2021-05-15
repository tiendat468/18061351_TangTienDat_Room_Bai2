package com.example.th_lab_06_b;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    List<product> getAll();

    @Query("SELECT * FROM product WHERE id IN (:sttP)")
    List<product> loadAllByIds(int[] sttP);

    @Query("SELECT * FROM product WHERE visit LIKE :place LIMIT 1")
    product findByName(String place);

    @Insert
    void insertAll(product... p);

    @Delete
    void delete(product p);

    @Insert
    void insertP(product p);
}
