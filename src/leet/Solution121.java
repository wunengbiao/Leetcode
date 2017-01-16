package leet;

/**
 * Created by wunengbiao on 2017/1/16.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {

        int n=prices.length;

        if(n<2) return 0;
        int[] buy=new int[n];
        int[] sell=new int[n];

        buy[0]=-prices[0];

        for(int i=1;i<n;i++){
            buy[i]=Math.max(buy[i-1],-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }

        return sell[n-1];
    }

    public static void main(String[] args){
        Solution121 s=new Solution121();

        int[] prices={7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(prices));
    }
}
