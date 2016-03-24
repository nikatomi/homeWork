package bll;

import model.Record;

import java.util.Comparator;
public class CompareField {

// TODO такой подход исползуется, но можно чуть улучшить добавить final, чтобы эти переменные не могли переопределиться
// TODO также можно добавить фабрику, которая будет возращать нужный кампаратор по названию, об этом на занятии
public static Comparator<Record>compareLastName = new Comparator<Record>() {
    @Override
    public int compare(Record o1, Record o2) {
        String st = o1.getLastname();
        String st2 = o2.getLastname();
        return st.compareTo(st2);
    }
};
    public static Comparator<Record> compareName = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            String st = o1.getName();
            String st2 = o2.getName();
            return st.compareTo(st2);
        }
    };
    public static Comparator<Record> compareTag = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            String st = o1.getTeg();
            String st2 = o2.getTeg();
            return st.compareTo(st2);
        }
    };
    public static Comparator<Record> compareID = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            int st = o1.getId();
            int st2 = o2.getId();
            return st - st2;
        }
    };
}
