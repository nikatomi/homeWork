import java.util.Comparator;

/**
 * Created by Андрей on 24.02.16.
 */
public class CompName implements Comparator<Zapis> {
    @Override
    public int compare(Zapis o1, Zapis o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
