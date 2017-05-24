package DP;

/**
 * Created by wunengbiao on 2017/3/4.
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV_188 {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        if(k>=len/2) return quickSolve(prices);

        int[][] dp=new int[k+1][len];
        for(int i=1;i<=k;i++){
            int tmpMax=-prices[0];
            for(int j=1;j<len;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+tmpMax); //表示以卖结束
                tmpMax=Math.max(tmpMax,dp[i-1][j-1]-prices[j]); //表示已买结束
            }
        }

        return dp[k][len-1];

    }

    private int quickSolve(int[] prices){
        int len=prices.length,profit=0;
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1])
                profit+=(prices[i]-prices[i-1]);
        }
        return profit;
    }
}
