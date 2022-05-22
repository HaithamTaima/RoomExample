package com.example.roomexample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {

    EmployeeRepository employeeRepository;
    private LiveData<List<Employee>> allEmployee;

    public EmployeeViewModel(Application application){
        super(application);
        employeeRepository = new EmployeeRepository(application);
        allEmployee = employeeRepository.getAllEmployee();
    }

    public LiveData<List<Employee>> getAllEmployee() {
        return allEmployee;
    }

    public void insert(Employee employee){
        employeeRepository.insert(employee);
    }

}
