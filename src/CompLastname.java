import java.util.Comparator;

/**
 * Created by Андрей on 24.02.16.
 */
public class CompLastname implements Comparator <Zapis> {
    @Override
    public int compare(Zapis o1, Zapis o2) {
        String st1 = o1.getLastname();
        String st2 = o2.getLastname();
        return st1.compareTo(st2);
    }
}
