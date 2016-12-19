package leet;
import java.lang.Integer;
/**
 * Created by wunengbiao on 2016/12/15.
 */
public class Solution394 {
    public String decodeString(String s) {
        int i=0;
        String res=decodeString(s,i);
        return res;
    }

    public String decodeString(String s,int i){
        String res="";
        while(i<s.length()&&s.charAt(i)!=']') {
            if (!isDigit(s.charAt(i))) {
                res += s.charAt(i++);
            } else {
                int n = 0;
                while (i < s.length() && isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i++) - '0';
                }
                i++;//"["
                String t = decodeString(s, i);
                i++;//"]"
                while (n-- > 0)
                    res += t;
            }
        }
        return res;
    }

    public boolean isDigit(char s){
        if(s-'0'>=0 && s-'0'<=9)
            return true;
        return false;
    }

    public static void main(String[] args){
        Solution394 s=new Solution394();
        String result=s.decodeString("3[a2[c]]");
        System.out.println(result);
    }



}
