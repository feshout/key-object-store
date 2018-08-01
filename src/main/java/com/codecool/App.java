package com.codecool;

import com.codecool.controller.AppController;
import com.codecool.connection.ServerConnection;


public class App 
{
    public static void main( String[] args ) {


        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        ServerConnection.createConnection(serverName, port);

        AppController appController = new AppController();
        appController.start();
    }
}
