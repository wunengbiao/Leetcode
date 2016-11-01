package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wunengbiao on 2016/10/21.
 */
public class Solution17 {
    Map<Integer,String> table=new HashMap<>();
    List<String> result=new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;
        table.put(2,"abc");
        table.put(3,"def");
        table.put(4,"ghi");
        table.put(5,"jkl");
        table.put(6,"mno");
        table.put(7,"pqrs");
        table.put(8,"tuv");
        table.put(9,"wxyz");
        int[] digit=new int[digits.length()];
        for(int i=0;i<digits.length();i++){
            digit[i]=(int)(digits.charAt(i)-'0');
        }
        backtrack(0,"",digit);
        return result;
    }

    public void backtrack(int n,String temp,int[] digits){
        if(n==digits.length){
            result.add(temp);
            return;
        }
        for(int i=0;i<table.get(digits[n]).length();i++){
            backtrack(n+1,temp+table.get(digits[n]).charAt(i),digits);
        }
    }

    public static void main(String[] args){
        Solution17 s=new Solution17();
        List<String> result=s.letterCombinations("23");
        System.out.println(result);
    }
}
