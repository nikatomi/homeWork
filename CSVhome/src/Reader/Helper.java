package Reader;

public class Helper {
    private String type;
    private String st;

    public Helper(String type, String st){
        this.type = type;
        this.st = st;
    }

    public  Object eqialsType(){
        if(type.equals("int")){

           return Integer.parseInt(st);

        }if(type.equals("double")){

           return Double.parseDouble(st);

        }if(type.equals("char")){

           return st.charAt(0);

        }if(type.equals("class java.lang.String")){

            return st;
        }
        return null;
    }

}
