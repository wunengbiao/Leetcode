package Str;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/19.
 */
public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if(s.length()==0) return true;

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                st.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(st.isEmpty() || st.pop()!='(')
                    return false;
            }
            else if(s.charAt(i)==']'){
                if(st.isEmpty() || st.pop()!='[')
                    return false;
            }
            else if(s.charAt(i)=='}'){
                if(s.isEmpty() || st.pop()!='{')
                    return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args){
        Valid_Parentheses_20 solution=new Valid_Parentheses_20();
        System.out.println(solution.isValid("()"));
    }
}
