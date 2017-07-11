package DP2;

import java.util.Stack;

/**
 * Created by wunengbiao on 2017/7/1.
 */
public class Longest_Valid_Parentheses_32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++){
            int t=stack.peek();
            if(t!=-1&& s.charAt(i)==')' && s.charAt(t)=='('){
                stack.pop();
                max=Math.max(max,i-stack.peek());

            }else{
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args){
        Longest_Valid_Parentheses_32 s=new Longest_Valid_Parentheses_32();
        System.out.println(s.longestValidParentheses("()()"));
    }
}
