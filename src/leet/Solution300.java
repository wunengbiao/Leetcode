package leet;

/**
 * Created by wunengbiao on 2016/9/25.
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int length=nums.length;
        if(length==0)
            return 0;
        int[] dp=new int[length];
        for(int i=0;i<length;i++){
            dp[i]=1;
        }
        int max=1;

        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    if(dp[i]>max)
                        max=dp[i];
                }
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution300 s=new Solution300();
        int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(s.lengthOfLIS(a));
    }
}
