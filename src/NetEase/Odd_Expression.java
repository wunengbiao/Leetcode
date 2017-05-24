package NetEase;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/4/14.
 */
public class Odd_Expression {
    public int solve(String expression){

        Stack<String> stack=new Stack<>();

        for(int i=0;i<expression.length();i++){

            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*' || expression.charAt(i)=='/'){
                stack.push(expression.charAt(i)+"");
            }

            else if(Character.isDigit(expression.charAt(i))){
                String nums=""+expression.charAt(i);
                while(i+1<expression.length() && Character.isDigit(expression.charAt(i+1))){
                    nums+=expression.charAt(++i);
                }
                if(stack.isEmpty() || stack.peek().equals("+") || stack.peek().equals("-")){
                    stack.push(nums);
                }
                else if(!stack.isEmpty() && stack.peek().equals("*") || stack.peek().equals("/")){
                    String op=stack.pop();
                    int before=Integer.parseInt(stack.pop());
                    int after=Integer.parseInt(nums);
                    stack.push(operate(op,before,after)+"");
                }

            }
        }

        int res=0;
        while(!stack.isEmpty()){
            int nums=Integer.parseInt(stack.pop());
            if(stack.isEmpty()) res+=nums;
            else{
                if(stack.pop().equals("+")) res+=nums;
                else if(stack.pop().equals("-")) res-=nums;
            }
        }

        return res;
    }

    public int operate(String op,int a,int b){
        int res=0;
        switch (op){
            case "+":
                res=a+b;
                break;
            case "-":
                res=a-b;
                break;
            case "*":
                res=a*b;
                break;
            case "/":
                res=a/b;
                break;
        }
        return res;
    }

    public static void main(String[] args){
        Odd_Expression s=new Odd_Expression();
        System.out.println(s.solve("1+2*3"));
    }
}
