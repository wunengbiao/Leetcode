package Baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wunengbiao on 2017/6/19.
 */
public class Identifier_Convert {
    public int getType(String s){
        String p="R(\\d+)C(\\d+)";
        if(Pattern.matches(p,s)){
            return 0;// RNCN
        }else{
            return 1;
        }
    }

    public String convertType0(String s){
        String p="R(\\d+)C(\\d+)";
        Pattern pattern=Pattern.compile(p);

        Matcher matcher=pattern.matcher(s);
        if(matcher.find()){
            int row=Integer.parseInt(matcher.group(1));
            int col=Integer.parseInt(matcher.group(2));
            String res="";
            while(col!=0){
                int c=col%26;
                col/=26;
                res+=(char)('A'+c-1);
            }
            StringBuilder sb=new StringBuilder(res);
            res=sb.reverse().toString();
            res+=row;
            return res;
        }
        return "";

    }

    public String convertType1(String s){
        String colstr="";
        int i=0;
        for(i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                colstr+=s.charAt(i);
            }else{
                break;
            }
        }
        int row=Integer.parseInt(s.substring(i));
        int j=0;
        int col=0;
        while(j<colstr.length()){
            col=col*26+(colstr.charAt(j)-'A'+1);
            j++;
        }

        return "R"+row+"C"+col;
    }

    public String solve(String s){
        if(getType(s)==0){
            return convertType0(s);
        }else{
            return convertType1(s);
        }
    }


    public static void main(String[] args){
        Identifier_Convert s=new Identifier_Convert();
        Scanner in=new Scanner(System.in);
        List<String> result=new ArrayList<>();

        int n=Integer.parseInt(in.nextLine());
        for(int i=0;i<n;i++){
            String line=in.nextLine();
            result.add(s.solve(line));
        }
        for(int i=0;i<n;i++){
            System.out.println(result.get(i));
        }
    }
}
