package com.codecool.dao;

import java.io.IOException;

public interface Accessable<T> {

    T getData(String keyName) throws IOException, ClassNotFoundException;
    void sendData(String keyName , T t) throws IOException;

}
