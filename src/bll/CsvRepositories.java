package bll;

import model.PhoneNumb;
import model.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

 class CsvRepositories extends Repository{
    public CsvRepositories(String nameRepositories) {
        super(nameRepositories);
    }
    File file = new File(nameRepositories);
    @Override
    protected List<Record> read() {
        list.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            String s = null;
            while((s = reader.readLine())!= null){
                String [] st = s.split(";");
                int id = Integer.parseInt(st[0].trim());
                String name = st[1].trim();
                String lastName = st[2].trim();
                String [] tempSt = st[3].substring(st[3].indexOf("\"")+1,st[3].lastIndexOf("\"")).split(" ");
                List<PhoneNumb> tempPnoneNumbList = new ArrayList<>();
                for( String stPhoneNumb : tempSt) {
                    String[] tel = stPhoneNumb.split("-");
                    String type = tel[0].trim();
                    String number = tel[1].trim();
                    PhoneNumb tempPnoneNumb = new PhoneNumb(type,number);
                    tempPnoneNumbList.add(tempPnoneNumb);
                }
                String tag = st[4].trim();
                String date = st[5].trim();
                Record temp = new Record(id,name,lastName,tempPnoneNumbList,tag,date);
                list.add(temp);
            }

        }catch (FileNotFoundException e){

        }catch (IOException e){

        }
        return list;
    }

    @Override
    protected List<Record> save() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("id;name;lastname;phone;tag;date");
            writer.write("\n");
            for(Record temp : list){
                StringBuilder stringbilder = new StringBuilder();
                String st = "";
                for(PhoneNumb tempPhoneNumb : temp.getPhoneNumb()){
                    String stPhoneNumb = tempPhoneNumb.getType()+"-"+tempPhoneNumb.getNumber()+" ";
                    st += stPhoneNumb;
                }

                stringbilder.append(Integer.toString(temp.getId())).append(";").append(temp.getName()).append(";")
                        .append(temp.getLastname()).append(";\"").append(st).append("\";").append(temp.getTeg()).append(";")
                        .append(temp.getDate());
                String s = stringbilder.toString();
                writer.write(s);
                writer.write("\n");
            }
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        return list;
    }
}
