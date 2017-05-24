package DP;

/**
 * Created by wunengbiao on 2017/2/26.
 */
public class Distinct_Subsequences_115 {

    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();

        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i][j-1];
                if(t.charAt(i-1)==s.charAt(j-1))
                    dp[i][j]+=dp[i-1][j-1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args){
        Distinct_Subsequences_115 s=new Distinct_Subsequences_115();
        System.out.println(s.numDistinct("rabbbit","rabbit"));
    }
}
