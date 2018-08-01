package com.codecool.dao;

import com.codecool.models.Product;
import com.codecool.connection.ServerConnection;

import java.io.IOException;

public class ProductDao implements Accessable<Product>{

    private ServerConnection serverConnection = ServerConnection.getConnection();

    public Product getData(String keyName){

        Product product = null;
        try {
            product = (Product) ServerConnection.getConnection().getData(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void sendData(String keyName ,Product product) {

        try {
            serverConnection.sendData(keyName, product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
