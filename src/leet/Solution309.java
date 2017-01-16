package leet;

/**
 * Created by wunengbiao on 2017/1/15.
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<2) return 0;

        int[] buy=new int[n];
        int[] sell=new int[n];

        buy[0]=-prices[0];

        for(int i=1;i<prices.length;i++){

            buy[i]=Math.max(buy[i-1],(i-2>=0?sell[i-2]-prices[i]:0-prices[i]));
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        return sell[n-1];
    }

    public static void main(String[] args){
        Solution309 s=new Solution309();
        int[] prices={1, 2, 3, 0, 2};
        int res=s.maxProfit(prices);
        System.out.println(res);
    }
}
