package leet;

import ChinaMobile.Solution;
import sun.font.TrueTypeFont;

/**
 * Created by wunengbiao on 2017/1/6.
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {

        if(s==null || p==null) return false;

        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]= true;

        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*' && dp[0][i-1]){
                dp[0][i+1]=true;
            }
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='.' || p.charAt(j)==s.charAt(i)){
                    dp[i+1][j+1]=dp[i][j];
                }

                if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)!=s.charAt(i) && p.charAt(j-1)!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }else{
                        System.out.println("p=["+p.charAt(j-1)+"]");
                        dp[i+1][j+1]=(dp[i+1][j]||dp[i][j+1]||dp[i+1][j-1]);
                    }
                }
            }
        }

        return dp[s.length()][p.length()];

    }

    public static void main(String[] args){
        Solution10 s=new Solution10();
        boolean res=s.isMatch("abab",".*");
        System.out.println(res);

    }
}
