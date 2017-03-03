package DP;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2017/2/27.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II_122 {

    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] buy=new int[prices.length];
        int[] sell=new int[prices.length];

        buy[0]=-prices[0];

        for(int i=1;i<prices.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }

        return sell[prices.length-1];
    }

    public static void main(String[] args){
        Best_Time_to_Buy_and_Sell_Stock_II_122 s=new Best_Time_to_Buy_and_Sell_Stock_II_122();
        int[] prices={7,1,5,3,6,4,5};
        System.out.println(s.maxProfit(prices));
    }
}
