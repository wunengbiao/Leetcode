package DP;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Climbing_Stairs_70 {

    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n<2) return 1;

        int[] dp=new int[n+1];
        dp[0]=1;

        for(int i=0;i<n;i++){
            if(i+1<=n){
                dp[i+1]+=dp[i];
            }
            if(i+2<=n){
                dp[i+2]+=dp[i];
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        Climbing_Stairs_70 s=new Climbing_Stairs_70();
        System.out.println(s.climbStairs(4));
    }

}
