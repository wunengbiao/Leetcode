package leet;

/**
 * Created by wunengbiao on 2017/1/16.
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int[] sell = new int[n];
//        int[] buy = new int[n];
//
//        int maxProfit = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            int preProfit = 0;
//            int postProfit = 0;
//            if (i < 2) preProfit = 0;
//            else {
//                buy[0] = -prices[0];
//                for (int j = 1; j < i; j++) {
//                    buy[j] = Math.max(buy[j - 1], -prices[j]);
//                    sell[j] = Math.max(sell[j - 1], buy[j - 1] + prices[j]);
//                }
//
//                preProfit = sell[i-1];
//            }
//
//
//
//            if (n - i < 2) postProfit = 0;
//            else {
//                buy[i] = -prices[i];
//                sell[i]=0;
//                for (int x = i + 1; x < n; x++) {
//                    buy[x] = Math.max(buy[x - 1], -prices[x]);
//                    sell[x] = Math.max(sell[x - 1], buy[x - 1] + prices[x]);
//                }
//
//                postProfit = sell[n - 1];
//            }
//
//            maxProfit = Math.max(maxProfit, postProfit + preProfit);
//
//        }
//
//        return maxProfit;
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first

            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
        }
        return release2;
    }

    public static void main(String[] args) {
        Solution123 s = new Solution123();
        int[] prices={7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(prices));

    }

}
