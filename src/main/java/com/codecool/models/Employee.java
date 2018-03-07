package com.codecool.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal incomes;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, BigDecimal incomes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.incomes = incomes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getIncomes() {
        return incomes;
    }

    public void setIncomes(BigDecimal incomes) {
        this.incomes = incomes;
    }

    public String toString(){
        return "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Salary: " + incomes.toString();
    }
}
