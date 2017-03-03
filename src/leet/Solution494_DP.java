package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/2/15.
 */
public class Solution494_DP {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        System.out.println(Arrays.toString(dp));
        return dp[sum+s];
    }

    public static void main(String[] args){
        Solution494_DP s=new Solution494_DP();
        int[] nums={1,1,1,1,1};
        int S=3;
        System.out.println("Result is:"+s.findTargetSumWays(nums,S));
    }

}
