package com.codecool.controller;

import com.codecool.dao.EmployeeDao;
import com.codecool.dao.ProductDao;
import com.codecool.models.Employee;
import com.codecool.models.Product;
import com.codecool.utils.DatabaseProvider;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppController {

    private EmployeeDao employeeDao;
    private ProductDao productDao;
    private Scanner scanner;
    private DatabaseProvider databaseProvider;

    public void start() {

//        Example Records

        Employee employee1 = new Employee("Marian", "Koster", "koster@gmail.com", new BigDecimal("2000.0"));
        Employee employee2 = new Employee("Adrian", "Marny", "marny@gmail.com", new BigDecimal("2000.0"));

        Product product1 = new Product("Kiełbasa", "Kiełba z pierzem", new BigDecimal("15.00"));
        Product product2 = new Product("Masło", "Masło 100%", new BigDecimal("5.00"));

//        End example records
        databaseProvider = DatabaseProvider.getConnection();
        employeeDao = new EmployeeDao();
        productDao = new ProductDao();
        scanner = new Scanner(System.in);
        String input = "";

//        employeeDao.sendData("Koza", employee1);

        Employee employee = employeeDao.getData("Koza");
        System.out.println(employee.toString());

        while (!input.equals("quit")) {

            input = scanner.nextLine();
            if(input.equals("1")){
                System.out.println(input);
//                Employee employee = employeeDao.getData("Koza");
//                System.out.println(employee.toString());
            }


        }

    }
}
