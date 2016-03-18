package bll;

import model.Field;
import java.util.Comparator;
public class CompareField {

// TODO такой подход исползуется, но можно чуть улучшить добавить final, чтобы эти переменные не могли переопределиться
// TODO также можно добавить фабрику, которая будет возращать нужный кампаратор по названию, об этом на занятии
    public static Comparator<Field>compareLastName = new Comparator<Field>() {

    @Override
    public int compare(Field o1, Field o2) {
        String st = o1.getLastname();
        String st2 = o2.getLastname();
        return st.compareTo(st2);
    }
};
    public static Comparator<Field> compareName = new Comparator<Field>() {
        @Override
        public int compare(Field o1, Field o2) {
            String st = o1.getName();
            String st2 = o2.getName();
            return st.compareTo(st2);
        }
    };
    public static Comparator<Field> compareTag = new Comparator<Field>() {
        @Override
        public int compare(Field o1, Field o2) {
            String st = o1.getTeg();
            String st2 = o2.getTeg();
            return st.compareTo(st2);
        }
    };
    public static Comparator<Field> compareID = new Comparator<Field>() {
        @Override
        public int compare(Field o1, Field o2) {
            int st = o1.getId();
            int st2 = o2.getId();
            return st - st2;
        }
    };
}
