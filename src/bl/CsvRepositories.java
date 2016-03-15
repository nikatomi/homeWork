package bl;
import bl.Repositories;
import model.Field;
import model.PhoneNumb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvRepositories implements Repositories {
    private List<Field>list = new ArrayList<>();
    private int i;
    File file = new File("testCvs.txt");
    public List<Field> addInFile(){
        try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
            Class clazz = Field.class;
            java.lang.reflect.Field[] field = clazz.getDeclaredFields();
            String[]st = new String[field.length];
            for (int j = 0; j <list.size() ; j++) {
                for (int k = 0; k <field.length ; k++) {
                    field[k].setAccessible(true);
                    Field h = list.get(j);
                    st[k] = ""+field[k].get(h);
                    buff.write(" "+st[k]+",");
                    field[k].setAccessible(false);
                }
                    buff.write("\n");
            }
            buff.flush();
        }catch (IOException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
            return list;
        }
    public List<Field> getFromFile(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                String[] st = bufferedReader.readLine().split(",");
                Class clazz = Field.class;
                Object ob = clazz.newInstance();
                java.lang.reflect.Field[] field = clazz.getDeclaredFields();
                for (int i = 0; i < field.length; i++) {
                    field[i].setAccessible(true);
                    if(field[i].getType().equals(int.class)){
                        int id = Integer.parseInt(st[i]);
                        field[i].set(ob, id);
                    }else if(field[i].getType().equals(List.class)){
                        String[]sList = st[i].split(",");
                        Class clazz2 = PhoneNumb.class;
                        Object obTel = clazz2.newInstance();
                        java.lang.reflect.Field[] fieldTel = clazz2.getDeclaredFields();
                        List<PhoneNumb> listTel = new ArrayList<>();
                        for (int j = 0; j <sList.length ; j++) {
                            String[]sTel = sList[j].split("-");
                            for (int k = 0; k <fieldTel.length ; k++) {
                                fieldTel[k].setAccessible(true);
                                fieldTel[k].set(obTel,sTel[k]);
                                fieldTel[k].setAccessible(false);
                            }
                            PhoneNumb tempTel = (PhoneNumb) obTel;
                            listTel.add(tempTel);
                        }
                        field[i].set(ob,listTel);
                    }else{
                        field[i].set(ob, st[i].trim());
                    }
                    field[i].setAccessible(false);
                }
                Field temp = (Field) ob;
                list.add(temp);
            }
            }catch(IOException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addField(Field temp) {
       // list = getFromFile();
        list.add(temp);
        addInFile();
    }

    @Override
    public Field search(String st) {
        return null;
    }

    @Override
    public void removeField(Field temp) {

    }

    @Override
    public void editField(Field temp) {

    }

    @Override
    public void sortLastName() {

    }

    @Override
    public void sortName() {

    }

    @Override
    public void sortTag() {

    }

    @Override
    public void sortId() {

    }

    @Override
    public List<Field> getList() {
        list = getFromFile();
        return list;
    }

    @Override
    public List<Field> searchLastName(String st) {
        return null;
    }

    @Override
    public List<Field> searchName(String st) {
        return null;
    }

    @Override
    public List<Field> searchTag(String st) {
        return null;
    }

    @Override
    public List<Field> searchDate(String st) {
        return null;
    }

}
