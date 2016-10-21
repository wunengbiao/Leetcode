package leet;

import ChinaMobile.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/20.
 */
public class Solution93 {

    List<String> result=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(0,s,"");
        return result;
    }

    public void backtrack(int n,String s,String temp){
        if(n==3){
            if(isLegal(s)){
                result.add(temp+s);
            }
            return;
        }

        for(int i=1;i<=3;i++){
            if(i<=s.length()) {
                String part = s.substring(0, i);
                if (isLegal(part)) {
                    backtrack(n + 1, s.substring(i), temp+part+".");
                } else {
                    return;
                }
            }
        }
    }

    public boolean isLegal(String s){
        if(s.equals("")) return false;
        if(s.length()>3) return false;
        int value = Integer.valueOf(s);
        if(value>255) return false;
        if(s.length()>1 && value<10) return false;
        if(s.length()>2 && value<100) return false;
        return true;
    }

    public static void main(String[] args){
        Solution93 s=new Solution93();
        String IP="0279245587303";
        List<String> result=s.restoreIpAddresses(IP);
        System.out.println(result);

    }
}
