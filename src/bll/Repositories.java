package bll;
import model.Record;

import java.util.Comparator;
import java.util.List;

public interface Repositories {
    void addRecord(Record temp);

    int search(String st);

    void removeRecord(int i);

    void editRecord(Record temp, int i);

    void sort(Comparator<Record> ob);

    List<Record> getList();

    List<Record> searchRecord(String st, String fieldName)throws NoSuchFieldException,IllegalAccessException;
}
