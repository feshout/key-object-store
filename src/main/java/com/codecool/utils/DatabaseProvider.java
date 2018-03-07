package com.codecool.utils;


import java.io.*;
import java.net.Socket;

public class DatabaseProvider {

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private WrapperHelper wrapperHelper;
    private static DatabaseProvider instance = null;


    private DatabaseProvider(String serverName, int port){

        try{
            this.socket = new Socket(serverName, port);
            setConnection();
            this.wrapperHelper = new WrapperHelper();

        } catch (IOException ex) {
            System.out.println("Error occured while connecting to database...");
        }
    }

    private void setConnection() throws IOException{

        System.out.println("Setting connection with database...");
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("Database connection established successfully.");
    }

    public Serializable getData(String dataKey) throws IOException, ClassNotFoundException {

        objectOutputStream.writeObject(dataKey);
        WrapperModel wrapperModel = (WrapperModel)objectInputStream.readObject();
        Serializable object = wrapperHelper.getObjectFromWrapper(wrapperModel);
        return object;
    }

    public void sendData(String key, Serializable object) throws IOException {

        WrapperModel wrapperModel = wrapperHelper.getWrapper(key, object);
        objectOutputStream.writeObject(wrapperModel);
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public static void createConnection(String serverName, int port) {

        if(instance == null) {
            instance = new DatabaseProvider(serverName, port);
        } else {
            getConnection();
        }
    }

    public static DatabaseProvider getConnection() {
        return instance;
    }
}
