package com.codecool.utils;


import java.io.*;

class WrapperHelper {


    WrapperModel getWrapper(String key, Serializable object) throws IOException{

        byte[] value = toByteArray(object);
        return new WrapperModel(key, value);
    }

    Serializable getObjectFromWrapper (WrapperModel wrapperModel) throws IOException, ClassNotFoundException {

        byte[] bytes =  wrapperModel.getValue();
        return toObjectFromByteArray(bytes);
    }


    private byte[] toByteArray(Serializable object) throws IOException {

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            try(ObjectOutputStream oos = new ObjectOutputStream(bos)){
                oos.writeObject(object);
            }
            return bos.toByteArray();
        }
    }

    private Serializable toObjectFromByteArray(byte[] ObjectAsByteArray) throws IOException, ClassNotFoundException{

        try(ByteArrayInputStream bos = new ByteArrayInputStream(ObjectAsByteArray)){
            try(ObjectInputStream ois = new ObjectInputStream(bos)){
                return (Serializable) ois.readObject();
            }
        }
    }
}
