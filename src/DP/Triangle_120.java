package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/2/27.
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int rows=triangle.size();
        int[][] dp=new int[rows][rows];

        int min=Integer.MAX_VALUE;

        for(int i=0;i<rows;i++){
            for(int j=0;j<=i;j++){
                if(i==0 && j==0) dp[i][j]=triangle.get(i).get(j);
                else{
                    int up=(i-1>=j?dp[i-1][j]:Integer.MAX_VALUE);
                    int left=(i-1>=0&&j-1>=0?dp[i-1][j-1]:Integer.MAX_VALUE);
                    dp[i][j]=triangle.get(i).get(j)+Math.min(up,left);
                }
                if(i==rows-1){
                    min=Math.min(min,dp[i][j]);
                }

            }
        }

        return min;
    }

    public static void main(String[] args){
        Triangle_120 s=new Triangle_120();

        /*
            [
                [2],
                [3,4],
                [6,5,7],
                [4,1,8,3]
            ]
         */
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(Arrays.asList(2));
//        triangle.add(Arrays.asList(3,4));
//        triangle.add(Arrays.asList(6,5,7));
//        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println("The minimal path is:"+s.minimumTotal(triangle));
    }



}
