package Str;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Reverse_Words_in_a_String_151 {
    public String reverseWords(String s) {
        s=s.trim();
        if(s.equals("")) return "";
        String[] strs=s.split(" ");
        List<String> list= Arrays.asList(strs);
        Collections.reverse(list);

        String[] newStrs=(String[]) list.toArray();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<newStrs.length-1;i++){
            if(!newStrs[i].equals("")){
                sb.append(newStrs[i]);
                sb.append(" ");
            }
        }

        if(!newStrs[newStrs.length-1].equals(" "))
        sb.append(newStrs[newStrs.length-1]);

        return sb.toString();
    }

    public static void main(String[] args){
        Reverse_Words_in_a_String_151 s=new Reverse_Words_in_a_String_151();

        System.out.println(s.reverseWords("   a   b "));
    }
}
