package bll;
import model.Record;
import model.PhoneNumb;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class CsvRepositoriesReflection extends Repository {
    public CsvRepositoriesReflection(String nameRepositories){
        super(nameRepositories);
    }
    protected List<Record> save(){

        File file = new File(nameRepositories);
        try(BufferedWriter buff = new BufferedWriter(new FileWriter(file))) {
            // создаём экземпляр класса Сlass типа Record....используем reflection api
            Class clazz = Record.class;
            // в массив типа Field(reflect) вводим все имеющиеся поля объекта типа Record(model)
            java.lang.reflect.Field[] field = clazz.getDeclaredFields();
            // инициализируем массив типа String
            String[]st = new String[field.length];
            for (int j = 0; j <list.size() ; j++) {
                for (int k = 0; k <field.length ; k++) {
                    // setAccessible даёт вазможность изменять закрытые поля объекта
                    field[k].setAccessible(true);
                    // записываем значения в file если поля типа List
                    if(field[k].getType().equals(List.class)){
                        Class clazzTel = PhoneNumb.class;
                        java.lang.reflect.Field[]fieldTel = clazzTel.getDeclaredFields();
                        String[]stTel = new String[fieldTel.length];
                        buff.write("\"");
                        for(int z = 0; z <list.get(j).getPhoneNumb().size();z++) {
                            for (int l = 0; l < stTel.length; l++) {
                                fieldTel[l].setAccessible(true);
                                if(l+1 != stTel.length){
                                    stTel[l] = "" + fieldTel[l].get(list.get(j).getPhoneNumb().get(z));
                                    buff.write(stTel[l] + "-");
                                }else{
                                    stTel[l] = "" + fieldTel[l].get(list.get(j).getPhoneNumb().get(z));
                                    buff.write(stTel[l]);
                                }
                                fieldTel[l].setAccessible(false);
                            }
                            if(z+1 != list.get(j).getPhoneNumb().size())
                            buff.write(" ");
                        }
                        buff.write("\",");
                    }else {
                        Record h = list.get(j);
                        st[k] = "" + field[k].get(h);
                        buff.write(" " + st[k] + ",");
                        field[k].setAccessible(false);
                    }
                }
                    buff.write("\n");
            }
            buff.flush();
        }catch (IOException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
            return list ;
        }

    protected List<Record> read(){

        File file = new File(nameRepositories);
        list.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                // используем массив типа String для хранения строки из файла и разделяем строку на элементы массива
                String[] st = bufferedReader.readLine().split(",");
                // создаём экземпляр класса Сlass типа Record....используем reflection api
                Class clazz = Record.class;
                Record ob = new Record();
                // в массив типа Record(reflect) вводим все имеющиеся поля объекта типа Record(model)
                java.lang.reflect.Field[] field = clazz.getDeclaredFields();
                for (int i = 0; i < field.length; i++) {
                    // setAccessible даёт вазможность изменять закрытые поля объекта
                    field[i].setAccessible(true);
                    // устанавливаем значение если тип поля int
                    if(field[i].getType().equals(int.class)){
                        int id = Integer.parseInt(st[i]);
                        field[i].set(ob, id);
                        //устанавливаем значение если поле типа List
                    }else if(field[i].getType().equals(List.class)){
                        // элемент с номерами телефонов разделяем на подмассив и убираем кавычки
                        String[]sList = st[i].substring(st[i].indexOf("\"")+1,st[i].lastIndexOf("\"")).split(" ");
                        // создаём экземпляр класса Сlass типа PhoneNumb....используем reflection api
                        Class clazzPhoneNumb = PhoneNumb.class;
                        // в массив типа Record(reflect) вводим все имеющиеся поля объекта типа PhoneNumb
                        java.lang.reflect.Field[] fieldTel = clazzPhoneNumb.getDeclaredFields();
                        List<PhoneNumb> listPhoneNumb = new ArrayList<>();
                        for (int j = 0; j <sList.length ; j++) {
                            Object obTel = clazzPhoneNumb.newInstance();
                            String[]sTel = sList[j].split("-");
                            for (int k = 0; k <fieldTel.length ; k++) {
                                fieldTel[k].setAccessible(true);
                                fieldTel[k].set(obTel,sTel[k]);
                                fieldTel[k].setAccessible(false);
                            }
                            PhoneNumb tempTel = (PhoneNumb) obTel;
                            listPhoneNumb.add(tempTel);
                        }
                        field[i].set(ob,listPhoneNumb);
                        // если поле типа String
                    }else{
                        field[i].set(ob, st[i].trim());
                    }
                    field[i].setAccessible(false);
                }
                list.add(ob);
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
}