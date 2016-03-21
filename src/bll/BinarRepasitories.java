package bll;

import model.Field;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarRepasitories implements Repositories {
    private List<Field>list = new ArrayList<>();
    private String nameRepositories;
    public BinarRepasitories(String nameRepositories){
        this.nameRepositories = nameRepositories;
    }
    private List<Field> addInFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nameRepositories);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        }catch (Exception e){
            System.out.println("Ошибка файла");
        }
        return list;
    }
    private List<Field>getFromFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(nameRepositories);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Field>) objectInputStream.readObject();
        }catch (Exception e){
            System.out.println("Файл пуст");
        }
        return list;
    }

    @Override
    public void addField(Field temp) {
        list = getFromFile();
        list.add(temp);
        addInFile();
    }

    @Override
    public int search(String st) {
        list = getFromFile();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getLastname().equals(st)){
                return  i;
            }
        }
        return  -1;
    }

    @Override
    public void removeField(int i) {
        list = getFromFile();
        list.remove(i);
        addInFile();
    }

    @Override
    public void editField(Field temp, int i) {
        list.set(i,temp);
        addInFile();
    }

    @Override
    public  void sort(Comparator<Field> ob) {
        list = getFromFile();
        Collections.sort(list,  ob);
        addInFile();
    }

    @Override
    public List<Field> getList() {
        list = getFromFile();
        return list;
    }
    public List<Field> searchLastName(String st){
        list = getFromFile();
        List<Field>temp = new ArrayList<>();
        for (Field h : list) {
            if(h.getLastname().equals(st)){
                temp.add(h);
            }
        }
        return temp;
    }

    @Override
    public List<Field> searchName(String st) {
        list = getFromFile();
        List<Field>temp = new ArrayList<>();
        for (Field h : list) {
            if(h.getName().equals(st)){
                temp.add(h);
            }
        }
        return temp;
    }

    @Override
    public List<Field> searchTag(String st) {
        list = getFromFile();
        List<Field>temp = new ArrayList<>();
        for (Field h : list) {
            if(h.getTeg().equals(st)){
                temp.add(h);
            }
        }
        return temp;
    }

    @Override
    public List<Field> searchDate(String st) {
        list = getFromFile();
        List<Field>temp = new ArrayList<>();
        for (Field h : list) {
            if(h.getDate().equals(st)){
                temp.add(h);
            }
        }
        return temp;
    }

}

