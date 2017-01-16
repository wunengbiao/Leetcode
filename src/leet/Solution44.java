package leet;

/**
 * Created by wunengbiao on 2017/1/6.
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {

        int m=s.length();
        int n=p.length();

        boolean[][] dp=new boolean[m+1][n+1];
        dp[m][n]=true;

        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*') break;
            else
                dp[s.length()][i]=true;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
                    dp[i][j]=dp[i+1][j+1];
                }else if(p.charAt(j)=='*'){
                    dp[i][j]=(dp[i+1][j] || dp[i][j+1]);
                }else{
                    dp[i][j]=false;
                }
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args){
        Solution44 s=new Solution44();
        System.out.println(s.isMatch("aab","c*a*b"));
    }
}
