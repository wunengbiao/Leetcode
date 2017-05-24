package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/19.
 */
public class Coin_Change_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i>=coin){
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount]>=amount+1?-1:dp[amount];
    }

    public static void main(String[] args){
        Coin_Change_322 s=new Coin_Change_322();
//        int[] coins={1,2,5};
        int[] coins={1};
        System.out.println(s.coinChange(coins,0));
    }
}
