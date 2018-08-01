package com.codecool.View;

import com.codecool.models.Employee;
import com.codecool.models.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class AppView {

    private static Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner(){
        return scanner;
    }

    public static String getKey(){
        System.out.println("Enter database key: ");
        String key = scanner.nextLine();
        return key;
    }

    public static String getInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void pause(){
        System.out.println("\nPress enter to continue.");
        String pause = scanner.nextLine();
    }

    public static Employee createEmployee(){

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter incomes: ");
        String incomesString = scanner.nextLine();
        BigDecimal incomes = new BigDecimal(incomesString);

        Employee employee = new Employee(firstName, lastName, email, incomes);
        return employee;
    }

    public static Product createProduct(){

        System.out.print("Enter product name");
        String name = scanner.nextLine();
        System.out.print("Enter product description");
        String description = scanner.nextLine();
        System.out.print("Enter product price");
        String priceString = scanner.nextLine();
        BigDecimal price = new BigDecimal(priceString);
        Product product = new Product(name, description, price);
        return product;
    }

    public static void printMenu() {

        System.out.println("1. Create employee");
        System.out.println("2. Create product");
        System.out.println("3. Get employee from db");
        System.out.println("4. Get product from db");
        System.out.println("0. Exit");
    }

}
