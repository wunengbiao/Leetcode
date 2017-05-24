package Str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/3/20.
 */
public class Restore_IP_Addresses_93 {

    List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0,"");
        return result;

    }

    public void backtrack(String str,int n,String temp){
        if(n==3){
            if(isValid(str)){
                String res=temp+str;
                result.add(res);
            }
            return;

        }
        for(int i=1;i<=3;i++){
            if(str.length()>=i && isValid(str.substring(0,i))){
                backtrack(str.substring(i),n+1,temp+str.substring(0,i)+'.');
            }
        }
    }

    public boolean isValid(String s){
        if(s.equals("")) return false;
        else if(s.length()>3) return false;
        int value=Integer.parseInt(s);
        if(s.length()==3 && value<100 || value>255) return false;
        else if(s.length()==2 && value<10) return false;
        return true;
    }

    public static void main(String[] args){
        Restore_IP_Addresses_93 solution=new Restore_IP_Addresses_93();
        System.out.println(solution.restoreIpAddresses("11111111111111111111111"));
    }
}
