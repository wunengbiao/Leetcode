package NetEase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/3/7.
 */
public class Square_String {
    public boolean isSquare(String str){
        if(str.length()%2!=0) return false;
        int half=str.length()/2;
        int i=0;

        while(i<half){
            if(str.charAt(i)!=str.charAt(i+half)) return false;
            i++;
        }

        return true;
    }

    public int numSquares(String str){
        Set<String> set=new HashSet<>();

        for(int i=0;i< str.length();i++){
            for(int j=i;j<str.length();j++){
                if(isSquare(str.substring(i,j)))
                    set.add(str.substring(i,j));
            }
        }

        return set.size();
    }

    public static void main(String[] args){
        Square_String s=new Square_String();
        String test="aaabccabccCCdsadasdaswedasdsadwqdsadsadcxzcsadsadsadzdasdsadsadsadsacxzcxzsadsadzxcdsfsdfsdasdsadsaadsadsadsadas";
        System.out.println(test.length());
        System.out.println(s.numSquares(test));
    }
}
