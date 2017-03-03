package DP;

/**
 * Created by wunengbiao on 2017/2/26.
 */
public class Distinct_Subsequences_115 {

    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++){
            dp[i][0]=1;
        }

        return 0;
    }
}
