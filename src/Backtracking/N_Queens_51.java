package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/17.
 */
public class N_Queens_51 {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        helper(n,1,new int[n+1]);
        return result;
    }

    //坐标从1开始
    public void helper(int n,int i,int[] res){
        if(i>n){
            result.add(convert(res));
            return;
        }

        for(int c=1;c<=n;c++){
            if(place(res,i,c)){
                res[i]=c;
                helper(n,i+1,res);
            }
        }
    }

    public List<String> convert(int[] res){
        List<String> list=new ArrayList<>();
        char[] str=new char[res.length-1];
        for(int i=1;i<res.length;i++){
            Arrays.fill(str,'.');
            str[res[i]-1]='Q';
            list.add(new String(str));
        }
        return list;
    }

    public boolean place(int[] res,int n,int pos){
        for(int i=1;i<n;i++){
            if(pos==res[i] || Math.abs(pos-res[i])==Math.abs(n-i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        N_Queens_51 s=new N_Queens_51();
        System.out.println(s.solveNQueens(8).size());
    }
}
