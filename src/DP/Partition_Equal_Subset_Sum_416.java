package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/27.
 */
public class Partition_Equal_Subset_Sum_416 {
    public boolean canPartition(int[] nums) {
        if(nums.length<2) return false;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;

        sum/=2;
        int[] dp=new int[sum+1];
        for(int i=0;i<nums.length;i++){

            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[sum]==sum;
    }

    public static void main(String[] args){
        Partition_Equal_Subset_Sum_416 s=new Partition_Equal_Subset_Sum_416();
        int[] nums={1, 5, 11, 5};
//        int[] nums={1,2,5};
        System.out.println(s.canPartition(nums));
    }
}
