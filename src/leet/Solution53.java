package leet;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2017/1/6.
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }

        return max;
    }

    public static void main(String[] args){
        Solution53 s=new Solution53();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int res=s.maxSubArray(nums);
        System.out.println(res);
    }
}
