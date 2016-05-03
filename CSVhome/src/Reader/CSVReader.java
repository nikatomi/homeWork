package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;

public class CSVReader<T> extends DecoratorReader {

    String s = "";
    String [] st;
    public CSVReader(T ob, Reader reader, String path) {
        super(ob, reader, path);
    }

    @Override
    public void read() {
        Class clazz = ob.getClass();
        Field[]fields = clazz.getDeclaredFields();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            s = reader.readLine();
            st = s.split(";");
        }catch (IOException e){

        }
        for(int i = 0;i<fields.length;i++){
            String type = String.valueOf(fields[i].getType());
            Helper helper = new Helper(type,st[i]);
            try {
                fields[i].set(ob,helper.eqialsType());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }
}
