package leet;

import java.lang.Math;
/**
 * Created by wunengbiao on 2016/9/27.
 */
public class Solution279 {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int cntSquare = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                cntSquare = Math.min(cntSquare, dp[i - j*j] + 1);
            }
            dp[i] = cntSquare;
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution279 s=new Solution279();
        int res=s.numSquares(18);
        System.out.println(res);
    }
}
