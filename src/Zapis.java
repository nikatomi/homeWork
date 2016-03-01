/**
 * Created by Андрей on 24.02.16.
 */
public class Zapis {
    private int id;
    private String name;
    private String lastname;
    private PhoneNumb phoneNumb;
    private String teg;

    public Zapis() {
        id = 0;
        name = null;
        lastname = null;
        phoneNumb = null;
        teg = null;
    }

    public Zapis(int id, String name, String lastname, PhoneNumb phoneNumb, String teg) {
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

    public void setPhoneNumb(PhoneNumb phoneNumb) {
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

    public PhoneNumb getPhoneNumb() {
        return phoneNumb;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTeg() {
        return teg;
    }
}
