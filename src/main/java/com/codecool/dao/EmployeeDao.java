package com.codecool.dao;

import com.codecool.models.Employee;
import com.codecool.utils.DatabaseProvider;

import java.io.IOException;

public class EmployeeDao implements Accessable<Employee> {

    private DatabaseProvider databaseProvider = DatabaseProvider.getConnection();

    public Employee getData(String keyName){

        Employee employee = null;
        try {
            employee = (Employee) DatabaseProvider.getConnection().getData(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void sendData(String key, Employee employee) {

        try {
            databaseProvider.sendData(key, employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
