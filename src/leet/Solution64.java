package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2016/9/26.
 */
public class Solution64 {
    public static int minPathSum(int[][] grid) {

        int row=grid.length;
        int col=grid[0].length;
        int[][] dp=new int[row][col];
        int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                if(i-1>=0){
                    up=dp[i-1][j];
                }
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                if(up==Integer.MAX_VALUE && left==Integer.MAX_VALUE){
                    dp[i][j]=grid[i][j];
                }else{
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }

                System.out.println("dp["+i+","+j+"]="+dp[i][j]);
            }
        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args){
        int[][] a=new int[2][2];
        a[0][0]=1;
        a[0][1]=2;
        a[1][0]=1;
        a[1][1]=1;
        int ret=minPathSum(a);
        System.out.println(ret);

    }
}
