import java.util.Comparator;

/**
 * Created by Андрей on 24.02.16.
 */
public class CompPhone implements Comparator<Zapis> {
    @Override
    public int compare(Zapis o1, Zapis o2) {
        String numb1 = o1.getPhoneNumb().getType();
        String numb2 = o2.getPhoneNumb().getType();
        return numb1.compareTo(numb2);
    }
}
