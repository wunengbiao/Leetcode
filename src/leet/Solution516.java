package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/2/14.
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {

        int len=s.length();
        int[][] dp=new int[len][len];

        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][len-1];
    }

    public static void main(String[] args){
        Solution516 s=new Solution516();
        String test1="cbbd";
        System.out.println(s.longestPalindromeSubseq(test1));
    }
}
