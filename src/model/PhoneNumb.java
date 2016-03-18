package model;

import java.io.Serializable;

// TODO 2. не сокращать название класса PhoneNumb
// TODO 3. переопределеить equals и hashCode
public class PhoneNumb implements Serializable{
    private String type;
    private String number;
    public PhoneNumb(){}
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

    @Override
    public String toString() {
        return type+" "+number;
    }
}
