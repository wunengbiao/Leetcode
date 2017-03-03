package leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/8.
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {

        Set<String> operators=new HashSet<>(Arrays.asList("+","-","*","/"));
        Stack<Integer> numbers=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!operators.contains(tokens[i]))
                numbers.push(Integer.parseInt(tokens[i]));
            else{
                int b=numbers.pop();
                int a=numbers.pop();
                numbers.push(operate(tokens[i],a,b));
            }
        }

        return numbers.pop();

    }

    public int operate(String operator,int a,int b){
        int result=0;
        switch (operator){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
        }
        return result;
    }

    public static void main(String[] args){
        Solution150 s=new Solution150();
        String[] tokens={"2", "1", "+", "3", "*"};
        String[] tokens2={"4", "13", "5", "/", "+"};
        System.out.println("Result is:"+s.evalRPN(tokens2));
    }
}
