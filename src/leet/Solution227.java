package leet;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/13.
 */
public class Solution227 {
    public int calculate(String s) {

        Stack<String> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') continue;
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/')
                st.push(""+s.charAt(i));

            else if(Character.isDigit(s.charAt(i))){
                String num=""+s.charAt(i);
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num+=s.charAt(++i);
                }

                if(st.isEmpty() || st.peek().equals("+") || st.peek().equals("-"))
                    st.push(num);

                else if(!st.isEmpty() && st.peek().equals("*") || st.peek().equals("/")){
                    String op=st.pop();
                    int before=Integer.parseInt(st.pop());
                    int after=Integer.parseInt(num);
                    st.push(operate(op,before,after)+"");
                }
            }

        }

        int res=0;
        while(!st.isEmpty()){
            int num=Integer.parseInt(st.pop());
            if(st.isEmpty()) res+=num;
            else{
                if(st.pop().equals("+")) res+=num;
                else res-=num;
            }
        }
        return res;
    }

    public int operate(String op,int a,int b){
        int res=0;
        switch (op){
            case "+":
                res= a+b;
                break;
            case "_":
                res= a-b;
                break;
            case "*":
                res= a*b;
                break;
            case "/":
                res= a/b;
                break;
        }
        return res;
    }

    public static void main(String[] args){
        Solution227 s=new Solution227();
        String test="3+2* 2";
        System.out.println("Result is:"+s.calculate(test));
    }
}
