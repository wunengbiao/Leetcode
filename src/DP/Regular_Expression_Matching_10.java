package DP;

/**
 * Created by wunengbiao on 2017/2/21.
 */
public class Regular_Expression_Matching_10 {

    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*' && dp[0][i-1])
                dp[0][i+1]=true;
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                    dp[i+1][j+1]=dp[i][j];
                }

                if(p.charAt(j)=='*'){
                    if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1]=(dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }

        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        Regular_Expression_Matching_10 s=new Regular_Expression_Matching_10();
        System.out.println(s.isMatch("abc","a*b*c"));
    }
}
