package model;

import java.io.Serializable;
import java.util.List;

// TODO 4. переопределеить equals и hashCode
public class Record implements Serializable{
    private int id;
    private String name;
    // TODO 1. назвать в camelCase т.е. lastname -> lastName
    private String lastname;
    private List<PhoneNumb> phoneNumb;
    private String teg;
    private String date;
    public Record(){}
    public Record(int id, String name, String lastname, List<PhoneNumb> phoneNumb, String teg) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("======================================\n" +
                "ID : %d \n" +
                "Фамилия : %s \n" +
                "Имя : %s \n" +
                "Тэг : %s \n" +
                "Телефон : %s \n" +
                "Дата изменения записи : %s \n" +
                "======================================\n",id,lastname,name,teg,phoneNumb.toString(),date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record field = (Record) o;

        if (id != field.id) return false;
        if (name != null ? !name.equals(field.name) : field.name != null) return false;
        if (lastname != null ? !lastname.equals(field.lastname) : field.lastname != null) return false;
        if (phoneNumb != null ? !phoneNumb.equals(field.phoneNumb) : field.phoneNumb != null) return false;
        if (teg != null ? !teg.equals(field.teg) : field.teg != null) return false;
        return date != null ? date.equals(field.date) : field.date == null;

    }

}
