package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/27.
 */
public class Combination_Sum_IV_377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);

        int[][] dp=new int[nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0]=1;
        }
      /*  for(int i=0;i<=target;i++){
            dp[0][i]=1;
        }*/

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args){
        Combination_Sum_IV_377 s=new Combination_Sum_IV_377();
        int[] nums={1,2,3};
//        int[] nums={1,2,5,10,20};
        System.out.println(s.combinationSum4(nums,4));
    }
}
