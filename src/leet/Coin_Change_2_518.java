package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/18.
 */
public class Coin_Change_2_518 {
//    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int coin : coins) {
//            for (int i = coin; i <= amount; i++) {
//                dp[i] += dp[i-coin];
//            }
//        }
//        return dp[amount];
//    }

    public int change(int amount, int[] coins) {

        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=1;

        for(int i=1;i<=coins.length;i++){
            dp[i][0]=1;
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j]+(j>=coins[i-1]?dp[i][j-coins[i-1]]:0);
            }
        }

        for(int i=0;i<=coins.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args){
        Coin_Change_2_518 s=new Coin_Change_2_518();
        int[] coins={1,2,5};
        System.out.println(s.change(5,coins));
    }
}
