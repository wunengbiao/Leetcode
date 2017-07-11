package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/18.
 */
public class Permutation_Sequence_60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=n;i++) nums.add(i);
        helper(nums,n,k);
        return res;
    }

    String res="";
    public void helper(List<Integer> nums,int n,int k){
        if(n==1){
            res+=nums.get(0);
            return;
        }
        int size=factorial(n-1);
        if(k<=size){
            res+=nums.get(0);
            nums.remove(0);
            helper(nums,n-1,k);
        }else{
            int g=(int)Math.ceil((double) k/factorial(n-1));
            res+=nums.get(g-1);
            nums.remove(g-1);
            int left=k-(g-1)*factorial(n-1);
            helper(nums,n-1,left);
        }
    }

    public int factorial(int n){
        if(n==0) return 0;
        int result=1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }

    public static void main(String[] args){
        Permutation_Sequence_60 s=new Permutation_Sequence_60();
        System.out.println(s.getPermutation(3,5));
//        System.out.println(Math.ceil(2));
//        System.out.println(Math.ceil(2.5));

//        int k=3;
//        System.out.println(Math.ceil(k/2));
    }

}
