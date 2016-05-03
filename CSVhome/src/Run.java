import Reader.Reader;
import Writer.*;
import Reader.*;

public class Run {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.toString());
//        a.a = "Alesya";
//        a.b = 25;
//        a.c = 'w';
//        a.d = 123.5;
//        a.st = "Winter its back";
//        Writer writer = new ConcretWriter(a);
//        writer = new CSVWriter(a,writer,"7.csv");
//        writer.write();
        Reader reader = new ConcretReader(a);
        reader = new CSVReader(a,reader,"7.csv");
        reader.read();
        System.out.println(a.toString());

    }
}

