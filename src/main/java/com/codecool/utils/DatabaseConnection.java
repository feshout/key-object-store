package com.codecool.utils;


import java.io.*;
import java.net.Socket;

public class DatabaseConnection {

    Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public DatabaseConnection(String serverName, int port){

        try{
            this.socket = new Socket(serverName, port);
            setConnection();

        } catch (IOException ex) {
            System.out.println("Error occured while connecting to database...");
        }
    }

    private void setConnection() throws IOException{

        System.out.println("Setting connection with database...");
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Database connection established successfully.");
    }

    public Object getData(String dataKey) throws IOException, ClassNotFoundException {

        objectOutputStream.writeUTF(dataKey);
        Object object = objectInputStream.readObject();
        return object;
    }

    public void sendData(Object object) throws IOException {

        objectOutputStream.writeObject(object);
    }
}
