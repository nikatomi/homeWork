package Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class CSVWriter<T> extends DeroratorWriter {
    String st = "";

 public CSVWriter(T ob, Writer writer, String path) {
        super(ob, writer, path);
    }

    @Override
    public void write() {
        Class clazz = ob.getClass();

        Field[]fields = clazz.getDeclaredFields();

        for(int i = 0;i<fields.length;i++){
            try {

                st += fields[i].get(ob)+";";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            writeString();
        }
    }

    private void writeString(){
        try {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

                writer.write(st);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
