package model;

import java.io.Serializable;
import java.util.List;

public class Field implements Serializable{
    private int id;
    private String name;
    private String lastname;
    private List<PhoneNumb> phoneNumb;
    private String teg;
    private final static String
            TMPL = "======================================\n" +
                   "ID : %d \n" +
                   "Фамилия : %s \n" +
                   "Имя : %s \n" +
                   "Тэг : %s \n" +
                   "Телефон : %s \n" +
                   "======================================\n";
    public Field(){}
    public Field(int id, String name, String lastname, List<PhoneNumb> phoneNumb, String teg) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumb = phoneNumb;
        this.teg = teg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumb(List<PhoneNumb> phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public void setTeg(String teg) {
        this.teg = teg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumb> getPhoneNumb() {
        return phoneNumb;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTeg() {
        return teg;
    }

    @Override
    public String toString() {
        return String.format(TMPL,id,lastname,name,teg,phoneNumb.toString());
    }
}
