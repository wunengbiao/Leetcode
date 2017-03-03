package DP;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Unique_Paths_62 {

    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int i=0;i<n;i++) dp[0][i]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        Unique_Paths_62 s=new Unique_Paths_62();
        System.out.println(s.uniquePaths(10,10));
    }
}
