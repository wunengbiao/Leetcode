package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/6/13.
 */
public class Combination_Sum_IV_377_2 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int[] res=new int[target+1];
        for(int i=0;i<res.length;i++){
            for(int num:nums){
                if(num>i)
                    break;
                else if(num==i)
                    res[i]+=1;
                else
                    res[i]+=res[i-num];
            }
        }

        return res[target];
    }

    public static void main(String[] args){
        Combination_Sum_IV_377_2 s=new Combination_Sum_IV_377_2();
        int[] nums={1,2,3};
        System.out.println(s.combinationSum4(nums,4));
    }

}
