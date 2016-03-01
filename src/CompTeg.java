import java.util.Comparator;

/**
 * Created by Андрей on 24.02.16.
 */
public class CompTeg implements Comparator<Zapis> {
    @Override
    public int compare(Zapis o1, Zapis o2) {
        String teg1 = o1.getTeg();
        String teg2 = o2.getTeg();
        return teg1.compareTo(teg2);
    }
}
