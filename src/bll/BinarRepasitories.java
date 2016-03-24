package bll;

import model.Record;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 class BinarRepasitories extends Repository {

    public BinarRepasitories(String nameRepositories){
        super(nameRepositories);
    }
    protected List<Record> addInFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nameRepositories);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        }catch (Exception e){
            System.out.println("Ошибка файла");
        }
        return list;
    }
    protected List<Record>getFromFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(nameRepositories);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Record>) objectInputStream.readObject();
        }catch (Exception e){
            System.out.println("Файл пуст");
        }
        return list;
    }
}

