package com.codecool;

import com.codecool.models.Employee;
import com.codecool.models.Product;
import com.codecool.utils.DatabaseConnection;

import java.math.BigDecimal;


public class App 
{
    public static void main( String[] args ) {

        Employee employee1 = new Employee("Marian", "Koster", "koster@gmail.com", new BigDecimal("2000.0"));
        Employee employee2 = new Employee("Adrian", "Marny", "marny@gmail.com", new BigDecimal("2000.0"));

        Product product1 = new Product("Kiełbasa", "Kiełba z pierzem", new BigDecimal("15.00"));
        Product product2 = new Product("Masło", "Masło 100%", new BigDecimal("5.00"));

        DatabaseConnection databaseConnection = new DatabaseConnection("192.168.10.195", 9000);

    }
}
