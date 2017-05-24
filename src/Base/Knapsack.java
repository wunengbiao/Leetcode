package Base;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/13.
 *
 * 0-1 背包问题
 */

public class Knapsack {

    int[][] dp;
    public int solve(int[] weights,int[] values,int limit){
        /**
         * weights:表示代价
         * values:表示价值
         * limit:表示最大的代价
         */
        int n=weights.length;
        dp=new int[n+1][limit+1];

        for(int i=1;i<=n;i++){
            for(int j=weights[i-1];j<=limit;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
            }
        }

        return dp[n][limit];
    }

    public int[] printPath(int[] weights,int[] values,int limit){
        int[] res=new int[weights.length];
        int i=weights.length-1;
        while(i>0){
            if(dp[i+1][limit]==dp[i][limit-weights[i]]+values[i]){
                res[i]=1;
                limit-=weights[i];
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args){
        int[] weights={2,3,1,4,6,5};
        int[] values={5,6,5,1,19,7};
        int limit=10;
        Knapsack s=new Knapsack();
        System.out.println(s.solve(weights,values,limit));
        System.out.println(Arrays.toString(s.printPath(weights,values,limit)));
    }

}
