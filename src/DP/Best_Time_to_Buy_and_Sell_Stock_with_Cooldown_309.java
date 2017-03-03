package DP;

/**
 * Created by wunengbiao on 2017/2/27.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] buy=new int[prices.length];
        int[] sell=new int[prices.length];
        buy[0]=-prices[0];

        for(int i=1;i<prices.length;i++){

            buy[i]=Math.max(i-2>=0?sell[i-2]-prices[i]:0-prices[i],buy[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }

        return sell[prices.length-1];
    }

    public static void main(String[] args){
        Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 s=new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309();
        int[] prices={1, 2, 3, 0, 2};
        System.out.println(s.maxProfit(prices));
    }
}
