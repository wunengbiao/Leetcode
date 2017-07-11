package DP2;

/**
 * Created by wunengbiao on 2017/7/1.
 */
public class Regular_Expression_Matching_10 {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            dp[0][i]=dp[0][i-1] && p.charAt(i-1)=='*';
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
                    dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*'){
                    if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.')
                        dp[i+1][j+1]=dp[i+1][j-1]; //表示p.charAt(j-1)字符匹配0次
                    else dp[i+1][j+1]=dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
