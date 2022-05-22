package com.example.roomexample;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

public class EmployeeRepository {
    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> allEmployee;

    public EmployeeRepository(Application application){
        RoomDB roomDB = RoomDB.getDatabase(application);
        employeeDao = roomDB.employeeDao();
        allEmployee = employeeDao.getAllEmployee();
    }


    public LiveData<List<Employee>> getAllEmployee() {
        return allEmployee;
    }

    void insert(Employee word) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            employeeDao.insert(word);
        });
    }


}
