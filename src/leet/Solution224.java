package leet;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/8.
 */
public class Solution224 {
    public int calculate(String s) {

        Stack<Integer> numbers=new Stack<>();

        int res=0;
        int sign=1;
        for(int i=0;i<s.length();i++){
            System.out.println("Stack Value:"+numbers);
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int cur=c-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    cur=10*cur+s.charAt(++i)-'0';
                }

                res=res+sign*cur;

            }

            if(c=='('){
                numbers.push(res);
                numbers.push(sign);
                res=0;
                sign=1;
            }
            if(c==')'){
                res=res*numbers.pop()+numbers.pop();
            }
            if(c=='-'){
                sign=-1;
            }
            if(c=='+'){
                sign=1;
            }
        }

        return res;
    }

    public static void main(String[] args){
        Solution224 s=new Solution224();

        String str="(1+(4+5+2)-3)+(6+8)";
        System.out.println(str+"="+s.calculate(str));

    }
}
