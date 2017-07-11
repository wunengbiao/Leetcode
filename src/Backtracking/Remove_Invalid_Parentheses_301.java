package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/21.
 */
public class Remove_Invalid_Parentheses_301 {
    public List<String> removeInvalidParentheses(String s){
        List<String> ans=new ArrayList<>();
        remove(s,ans,0,0,new char[]{'(',')'});
        return ans;
    }

    public void remove(String s,List<String> ans,int last_i,int last_j,char[] par){
        for(int i=last_i,stack=0;i<s.length();i++){
            if(s.charAt(i)==par[0]) stack++;
            if(s.charAt(i)==par[1]) stack--;
            if(stack>=0) continue;
            for(int j=last_j;j<=i;j++)
                if(s.charAt(j)==par[1] && (j==last_j  || s.charAt(j-1)!=par[1]))
                    remove(s.substring(0,j)+s.substring(j+1),ans,i,j,par);
            return;//无法完成
        }

        String reversed=new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            remove(reversed,ans,0,0,new char[]{')','('});
        else
            ans.add(reversed);
    }

    public static void main(String[] args){
        Remove_Invalid_Parentheses_301 s=new Remove_Invalid_Parentheses_301();
        System.out.println(s.removeInvalidParentheses("())()"));
    }
}
