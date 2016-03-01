import java.util.Comparator;

/**
 * Created by Андрей on 24.02.16.
 */
public class CompId implements Comparator<Zapis> {
    @Override
    public int compare(Zapis o1, Zapis o2) {
        int id1 = o1.getId();
        int id2 = o2.getId();
        if(id1 > id2) {
            return 1;
        }
        else if(id1 < id2) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
