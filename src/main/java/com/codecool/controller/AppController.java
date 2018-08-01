package com.codecool.controller;

import com.codecool.View.AppView;
import com.codecool.dao.EmployeeDao;
import com.codecool.dao.ProductDao;
import com.codecool.models.Employee;
import com.codecool.models.Product;
import com.codecool.connection.ServerConnection;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class AppController {

    private EmployeeDao employeeDao;
    private ProductDao productDao;
    private ServerConnection serverConnection;

    public void start() {

        serverConnection = ServerConnection.getConnection();
        employeeDao = new EmployeeDao();
        productDao = new ProductDao();
        String input = "";

        while (!input.equals("0")) {

            try {
                AppView.printMenu();
                AppView.printMessage("Enter operation number: ");
                input = AppView.getScanner().nextLine();
                if(input.equals("1")) {
                    String key = AppView.getKey();
                    Employee employee = AppView.createEmployee();
                    employeeDao.sendData(key, employee);
                    AppView.printMessage("Employee saved successfully");
                    AppView.pause();
                } else if(input.equals("2")) {
                    String key = AppView.getKey();
                    Product product = AppView.createProduct();
                    productDao.sendData(key, product);
                    AppView.printMessage("Product saved successfully");
                    AppView.pause();
                } else if(input.equals("3")) {
                    String key = AppView.getKey();
                    Employee employee = employeeDao.getData(key);
                    System.out.println(employee.toString());
                    AppView.pause();
                } else if(input.equals("4")){
                    String key = AppView.getKey();
                    Product product = productDao.getData(key);
                    System.out.println(product.toString());
                    AppView.pause();
                } else if(input.equals("0")){
                    serverConnection.closeConnection();
                } else {
                    AppView.printMessage("Wrong option!");
                }

            } catch (IOException e) {
                System.out.println("Database connection lost");
            }
        }
    }
}
