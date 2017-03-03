package DP;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Unique_Paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;
        if(rows==0 || cols==0) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        int[][] dp=new int[rows][cols];
        dp[0][0]=1;
        for(int i=1;i<rows;i++){
            if(obstacleGrid[i][0]==1)
                dp[i][0]=0;
            else
                dp[i][0]=dp[i-1][0];
        }

        for(int i=1;i<cols;i++){
            if(obstacleGrid[0][i]==1)
                dp[0][i]=0;
            else
                dp[0][i]=dp[0][i-1];
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String[] args){
        Unique_Paths_II_63 s=new Unique_Paths_II_63();
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}
