package bll;

import model.Record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Repository implements IntefaceRepository{
    protected List<Record> list = new ArrayList<>();
    protected String nameRepositories;

    public Repository(String nameRepositories) {
        this.nameRepositories = nameRepositories;
    }

    abstract protected List<Record>addInFile();
    abstract protected List<Record>getFromFile();

    @Override
    public void addRecord(Record temp) {
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
    public void removeRecord(int i) {
        list = getFromFile();
        list.remove(i);
        addInFile();
    }

    @Override
    public void editRecord(Record temp, int i) {
        list.set(i,temp);
        addInFile();
    }

    @Override
    public void sort(Comparator<Record> ob) {
        list = getFromFile();
        Collections.sort(list,  ob);
        addInFile();
    }

    @Override
    public List<Record> getList() {
        list = getFromFile();
        return list;
    }

    @Override
    public List<Record> searchRecord(String st, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        list = getFromFile();
        List<Record>temp = new ArrayList<>();
        Class clazz = Record.class;
        java.lang.reflect.Field field = clazz.getDeclaredField(fieldName);
        for (Record h:list) {
            field.setAccessible(true);
            if(field.get(h).equals(st)){
                temp.add(h);
            }
            field.setAccessible(false);
        }
        return temp;
    }
}
