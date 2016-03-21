package bll;
import model.Field;

import java.util.Comparator;
import java.util.List;

public interface Repositories {
    void addField(Field temp);

    int search(String st);

    void removeField(int i);

    void editField(Field temp,int i);

    void sort(Comparator<Field> ob);

    List<Field> getList();

    List<Field> searchField(String st,String fieldName)throws NoSuchFieldException,IllegalAccessException;
}
