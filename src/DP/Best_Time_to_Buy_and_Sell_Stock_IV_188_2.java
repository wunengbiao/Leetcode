package DP;

/**
 * Created by wunengbiao on 2017/6/13.
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV_188_2 {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        if(k>=len/2) return quickSolve(prices);

        int[][] t=new int[k+1][len];
        for(int i=1;i<=k;i++){
            int tmpMax=-prices[0];
            for(int j=1;j<len;j++){
                t[i][j]=Math.max(t[i][j-1],prices[j]+tmpMax);//卖出
                tmpMax=Math.max(tmpMax,t[i-1][j-1]-prices[j]);//买进
            }
        }
        return t[k][len-1];
    }

    private int quickSolve(int[] prices){
        int len=prices.length,profit=0;
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]) profit+=prices[i]-prices[i-1];
        }
        return profit;
    }

    public static void main(String[] args){
    }
}
