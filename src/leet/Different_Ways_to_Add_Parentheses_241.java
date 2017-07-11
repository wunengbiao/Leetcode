package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/7/4.
 */
public class Different_Ways_to_Add_Parentheses_241 {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input,new HashSet<>(Arrays.asList('+','-','*')));
    }

    public List<Integer> helper(String s, Set<Character> ops){
        List<Integer> res=new ArrayList<>();
        if(isDigit(s)){
            res.add(Integer.parseInt(s));
            return res;
        }
        for(int i=0;i<s.length();i++){
            if(ops.contains(s.charAt(i))){
                List<Integer> lefts=helper(s.substring(0,i),ops);
                List<Integer> rights=helper(s.substring(i+1),ops);
                for(int left:lefts){
                    for(int right:rights){
                       res.add(operate(left,right,s.charAt(i)));
                }
                }
            }
        }
        return res;
    }

    public boolean isDigit(String s){
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public int operate(int a,int b,char op){
        int sum=0;
        switch (op){
            case '+':
                sum= a+b;
                break;
            case '-':
                sum= a-b;
                break;
            case '*':
                sum= a*b;
                break;
            case '/':
                sum= a/b;
                break;
        }
        return sum;
    }

    public static void main(String[] args){
        Different_Ways_to_Add_Parentheses_241 s=new Different_Ways_to_Add_Parentheses_241();
        System.out.println(s.diffWaysToCompute("2*3-4*5"));
    }
}
