package lintCode;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/4.
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。
 * 你需要让平方数的个数最少。
 */
public class PerfectSqures {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.sqrt(i);j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        PerfectSqures s=new PerfectSqures();
        System.out.println(s.numSquares(24));
    }
}
