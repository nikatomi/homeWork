package bll;
import model.Field;
import java.util.List;

public interface Repositories {
    void addField(Field temp);

    Field search(String st);

    void removeField(Field temp);

    void editField(Field temp);

    /// TODO  не разбивать интерфейс, объеденить в один метод с параметром>>>
    void sortLastName();

    void sortName();

    void sortTag();

    void sortId();
    //<<<

    // TODO лучше подобрать имя по понятнее, например getAll
    List<Field> getList();

    // TODO >>> аналогично, не нужно разбивать логику на столько методов, а если добавится еще поле и
    // еще поиск? придется менять интерфейс
    List<Field> searchLastName(String st);

    List<Field> searchName(String st);

    List<Field> searchTag(String st);

    List<Field> searchDate(String st);

    // <<<
}
