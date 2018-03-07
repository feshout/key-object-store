package com.codecool;

import com.codecool.controller.AppController;
import com.codecool.dao.EmployeeDao;
import com.codecool.models.Employee;
import com.codecool.models.Product;
import com.codecool.utils.DatabaseProvider;

import java.io.IOException;
import java.math.BigDecimal;


public class App 
{
    public static void main( String[] args ) {


//        String serverName = args[0];
//        int port = Integer.parseInt(args[1]);

        DatabaseProvider.createConnection("192.168.10.195", 9000); // for testing
//        DatabaseProvider.createConnection(serverName, port);

        AppController appController = new AppController();
        appController.start();
    }
}
