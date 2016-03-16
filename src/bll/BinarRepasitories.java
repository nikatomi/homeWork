package bll;

import model.Field;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarRepasitories implements Repositories {
    private List<Field>list = new ArrayList<>();
    private int i;
    private List<Field> addInFile(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        }catch (Exception e){
            System.out.println("Ошибка файла");
        }
        return list;
    }
    private List<Field>getFromFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
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
    public Field search(String st) {
        list = getFromFile();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getLastname().equals(st)){
                this.i = i;
                return  list.get(i);
            }
        }
        return  null;
    }

    @Override
    public void removeField(Field temp) {
        list = getFromFile();
        list.remove(this.i);
        addInFile();
    }

    @Override
    public void editField(Field temp) {
        list.set(this.i,temp);
        addInFile();
    }
    public void sortLastName(){
        list = getFromFile();
        Collections.sort(list, CompareField.compareLastName);
        addInFile();
    }
    public void sortName(){
        list = getFromFile();
        Collections.sort(list, CompareField.compareName);
        addInFile();
    }
    public void sortTag(){
        list = getFromFile();
        Collections.sort(list, CompareField.compareTag);
        addInFile();
    }
    public void sortId(){
        list = getFromFile();
        Collections.sort(list, CompareField.compareID);
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

