package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/18.
 */
public class Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(0);
        if(n==0){
            return res;
        }
        helper(1,n,res);
        return res;
    }
    public void helper(int i,int n,List<Integer> res){
        if(i>n) return;
        int size=(int)Math.pow(2,i-1);
        for(int c=size-1;c>=0;c--){
            res.add(res.get(c)+size);
        }
        helper(i+1,n,res);
    }

    public static void main(String[] args){
        Gray_Code_89 s=new Gray_Code_89();
        System.out.println(s.grayCode(3));
    }
}
