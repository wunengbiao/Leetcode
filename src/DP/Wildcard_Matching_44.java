package DP;

import leet.Solution10;

/**
 * Created by wunengbiao on 2017/2/21.
 */
public class Wildcard_Matching_44 {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*' && dp[0][i]){
                dp[0][i+1]=true;
            }
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
                    dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*'){
                    dp[i+1][j+1]=(dp[i][j] || dp[i+1][j] || dp[i][j+1]);
                }

            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        Wildcard_Matching_44 s=new Wildcard_Matching_44();
        String str1="aab";String p1="a*c";
        String str2="";String p2="?";
        System.out.println(s.isMatch(str2,p2));
    }
}
