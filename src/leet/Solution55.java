package leet;

/**
 * Created by wunengbiao on 2016/10/5.
 */
public class Solution55 {

    public boolean canJump(int[] nums) {

        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=0;

        for(int i=0;i<n-1;i++){
            dp[i+1]=Math.max(nums[i],dp[i-1]-1);
            if(dp[i+1]==0){
                return false;
            }
        }
        return true;
    }
}
