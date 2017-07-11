package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/6/27.
 */
public class Regular_Expression_Matching_10 {
    public boolean isMatch(String s, String p) {

        int m=s.length();
        int n=p.length();

        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            dp[0][i]=dp[0][i-1] && p.charAt(i-1)=='*';
        }

        System.out.println(Arrays.toString(dp[0]));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)==s.charAt(i) && p.charAt(j-1)!='.')
                        dp[i+1][j+1]=dp[i+1][j-1];
                    else{
                        dp[i+1][j+1]=dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args){
        Regular_Expression_Matching_10 s=new Regular_Expression_Matching_10();
        System.out.println(s.isMatch("aab", "c*a*b"));
    }
}
