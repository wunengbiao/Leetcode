package DP;

/**
 * Created by wunengbiao on 2017/6/9.
 */
public class Burst_Balloons_312 {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

        int[][] dp=new int[n][n];

        for(int len=0;len<n;len++){
            for(int i=0;i<n-len;i++){
                int j=i+len;

                for(int k=i;k<=j;k++){
                    int l=i>0?nums[i-1]:1;
                    int r=j<n-1?nums[j+1]:1;

                    int left=k-1>=i?dp[i][k-1]:0;
                    int right=k+1<=j?dp[k+1][j]:0;

                    dp[i][j]=Math.max(dp[i][j],l*nums[k]*r+left+right);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args){
        Burst_Balloons_312 s=new Burst_Balloons_312();
        int[] nums={3,1,5,8};
        System.out.println(s.maxCoins(nums));
    }
}
