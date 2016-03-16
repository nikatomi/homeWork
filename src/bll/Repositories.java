package bll;
import model.Field;
import java.util.List;

public interface Repositories {
    void addField(Field temp);

    Field search(String st);

    void removeField(Field temp);

    void editField(Field temp);

    void sortLastName();

    void sortName();

    void sortTag();

    void sortId();

    List<Field> getList();

    List<Field> searchLastName(String st);

    List<Field> searchName(String st);

    List<Field> searchTag(String st);

    List<Field> searchDate(String st);
}
