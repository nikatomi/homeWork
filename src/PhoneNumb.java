/**
 * Created by Андрей on 24.02.16.
 */
public class PhoneNumb {
    private String type;
    private String number;
    public PhoneNumb(){
        type = null;
        number = null;
    }
    public PhoneNumb(String type,String number){
        this.type = type;
        this.number = number;
    }
    public void setType(String type){
        this.type = type;
    }
    public  void setNumber(String number){
        this.number = number;
    }
    public String getType(){
        return type;
    }
    public String getNumber(){
        return number;
    }
}
