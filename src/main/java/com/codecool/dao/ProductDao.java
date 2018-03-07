package com.codecool.dao;

import com.codecool.models.Product;
import com.codecool.utils.DatabaseProvider;

import java.io.IOException;

public class ProductDao implements Accessable<Product>{

    private DatabaseProvider databaseProvider = DatabaseProvider.getConnection();

    public Product getData(String keyName){

        Product product = null;
        try {
            product = (Product) DatabaseProvider.getConnection().getData(keyName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void sendData(String keyName ,Product product) {

        try {
            databaseProvider.sendData(keyName, product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
