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

    abstract protected List<Record> save();
    abstract protected List<Record> read();

    @Override
    public void addRecord(Record temp) {
        list = read();
        list.add(temp);
        save();
    }

    @Override
    public int search(String st) {
        list = read();
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getLastname().equals(st)){
                return  i;
            }
        }
        return  -1;
    }

    @Override
    public void removeRecord(int i) {
        list = read();
        list.remove(i);
        save();
    }

    @Override
    public void editRecord(Record temp, int i) {
        list.set(i,temp);
        save();
    }

    @Override
    public void sort(Comparator<Record> ob) {
        list = read();
        Collections.sort(list,  ob);
        save();
    }

    @Override
    public List<Record> getList() {
        list = read();
        return list;
    }

    @Override
    public List<Record> searchRecord(String st, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        list = read();
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
