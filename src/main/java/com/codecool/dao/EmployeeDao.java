package com.codecool.dao;

import com.codecool.models.Employee;
import com.codecool.connection.ServerConnection;

import java.io.IOException;

public class EmployeeDao implements Accessable<Employee> {

    private ServerConnection serverConnection = ServerConnection.getConnection();

    public Employee getData(String keyName){

        Employee employee = null;
        try {
            employee = (Employee) ServerConnection.getConnection().getData(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void sendData(String key, Employee employee) {

        try {
            serverConnection.sendData(key, employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
