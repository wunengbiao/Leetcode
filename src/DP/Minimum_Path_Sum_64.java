package DP;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        if(rows==0 || cols==0) return 0;
        int[][] dp=new int[rows][cols];
        dp[0][0]=grid[0][0];
        for(int i=1;i<rows;i++) dp[i][0]=grid[i][0]+dp[i-1][0];
        for(int i=1;i<cols;i++) dp[0][i]=grid[0][i]+dp[0][i-1];
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
