package DP;

import java.util.HashMap;

/**
 * Created by wunengbiao on 2017/6/10.
 */
public class Arithmetic_Slices_II_Subsequence_446_2 {
    public int numberOfArithmeticSlices(int[] A) {
        int res=0;
        HashMap<Integer,Integer>[] maps=new HashMap[A.length];
        for(int i=0;i<A.length;i++){
            maps[i]=new HashMap<>();
            int num=A[i];
            for(int j=0;j<i;j++){
                if((long)num-A[j]>Integer.MAX_VALUE) continue;
                if((long)num-A[j]<Integer.MIN_VALUE) continue;

                int diff=num-A[j];
                int count=maps[j].getOrDefault(diff,0);
                maps[i].put(diff,maps[i].getOrDefault(diff,0)+count+1);
                res+=count;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Arithmetic_Slices_II_Subsequence_446_2 s=new Arithmetic_Slices_II_Subsequence_446_2();
        int[] nums={5,5};
        System.out.println(s.numberOfArithmeticSlices(nums));
    }
}
