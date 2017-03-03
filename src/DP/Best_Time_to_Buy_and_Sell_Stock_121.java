package DP;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2017/2/27.
 *
 * buy[i] 表示在i次之前买
 * sell[i] 表示在第i次卖
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public int maxProfit(int[] prices) {
        int[] buy=new int[prices.length];
        int[] sell=new int[prices.length];
        int maxProfit=0;

        for(int i=0;i<prices.length;i++){
            if(i==0){
                buy[i]=prices[i];
            }else{
                buy[i]=Math.min(prices[i],buy[i-1]);
            }

            sell[i]=prices[i]-buy[i];
            maxProfit=Math.max(maxProfit,sell[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args){
        Best_Time_to_Buy_and_Sell_Stock_121 s=new Best_Time_to_Buy_and_Sell_Stock_121();
        int[] prices={7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}
