package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/19.
 */
public class Generate_Parentheses_22 {
//    public List<String> generateParenthesis(int n) {
//
//        Set<String> result=generate(n);
//        List<String> res=new ArrayList<>(result);
//        Collections.sort(res);
//        return res;
//    }
//
//    public Set<String> generate(int n){
//        Set<String> res=new LinkedHashSet<>();
//        if(n==1){
//            res.add("()");
//            return res;
//        }
//        Set<String> tmp=generate(n-1);
//        for(String s:tmp){
//            res.add('('+s+')');
//            res.add(s+"()");
//            res.add("()"+s);
//        }
//        return res;
//    }
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n){
        generate("",n*2,0);
        return res;
    }

    public void generate(String str,int n,int m){
        if(n==0 && m==0){
            res.add(str);
        }

        if(n>0) generate(str+'(',n-1,m+1);
        if(m>0) generate(str+')',n-1,m-1);
    }


    public static void main(String[] args){
        Generate_Parentheses_22 solution=new Generate_Parentheses_22();
        List<String> res=solution.generateParenthesis(3);
        System.out.println(res);
    }
}
