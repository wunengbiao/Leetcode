package QuanGuo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class XunHuanCi {
    public int solve(String[] strs){
        if(strs.length<2) return strs.length;
        Set<String> set=new HashSet<>();
        set.add(strs[0]);

        for(int i=1;i<strs.length;i++){
            boolean flag=false;
            for(String dic:set){
                if(isSame(dic,strs[i])) flag=true;
            }
            if(!flag) set.add(strs[i]);
        }
        return set.size();
    }

    public boolean isSame(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        else{
            for(int i=0;i<s1.length();i++){
                String before=s1.substring(0,i);
                String after=s1.substring(i);

                if((after+before).equals(s2)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        XunHuanCi solve=new XunHuanCi();
        Scanner in =new Scanner(System.in);

        int n=in.nextInt();
        String[] strs=new String[n];

        for(int i=0;i<n;i++){
            strs[i]=in.next();
        }
        System.out.println(solve.solve(strs));
    }
}
