package leet;

import ChinaMobile.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/1/16.
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        int[][] dp=new int[n][];

        for(int i=0;i<n;i++){
            dp[i]=new int[i+1];

            for(int j=0;j<=i;j++){
                if(i==0 && j==0) dp[i][j]=triangle.get(i).get(j);
                else if(j==0) dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                else if(i==j) dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }

        int min=dp[n-1][0];
        for(int i=1;i<n;i++){
            if(dp[n-1][i]<min) min=dp[n-1][i];
        }

        System.out.println(Arrays.toString(dp[n-1]));

        return min;
    }

    public static void main(String[] args){
        Solution120 s=new Solution120();

        List<Integer> l0= Arrays.asList(2);
        List<Integer> l1= Arrays.asList(3,4);
        List<Integer> l2= Arrays.asList(6,5,7);
        List<Integer> l3= Arrays.asList(4,1,8,3);

        List<List<Integer>> triangle=Arrays.asList(l0,l1,l2,l3);
        System.out.println(triangle.toString());

        System.out.println(s.minimumTotal(triangle));
    }
}
