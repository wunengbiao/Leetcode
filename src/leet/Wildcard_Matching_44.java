package leet;

/**
 * Created by wunengbiao on 2017/6/26.
 */
public class Wildcard_Matching_44 {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++){
            dp[0][i] = dp[0][i-1] && p.charAt(i-1) == '*';
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)==s.charAt(i) || p.charAt(j)=='?') dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*') dp[i+1][j+1]=(dp[i][j+1] || dp[i+1][j]);
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        Wildcard_Matching_44 s=new Wildcard_Matching_44();
        System.out.println(s.isMatch("aa", "aa"));
    }
}
