package Str;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Valid_Number_65 {
    public boolean isNumber(String s) {
        try {
            if(!valid(s)) return false;
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return false;
        }
    }

    public boolean valid(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='e') continue;
            if(s.charAt(i)>='a' && s.charAt(i)<='z' || s.charAt(i)>='A' && s.charAt(i)<='Z') return false;
        }
        return true;
    }

    public static void main(String[] args){
        Valid_Number_65 s=new Valid_Number_65();
        System.out.println(s.isNumber("0"));
        System.out.println(s.isNumber(" 0.1"));
        System.out.println(s.isNumber("abc"));
        System.out.println(s.isNumber("1 a"));
        System.out.println(s.isNumber("2e10"));
        System.out.println(s.isNumber("959440.94f"));
    }

}
