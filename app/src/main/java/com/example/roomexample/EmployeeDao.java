package com.example.roomexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee employee);

    @Query("DELETE FROM Employee")
    void deleteAll();

    @Query("SELECT * FROM Employee")
    LiveData<List<Employee>> getAllEmployee();
}
