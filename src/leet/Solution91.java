package leet;

import ChinaMobile.Solution;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/1/10.
 */
public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution91 s = new Solution91();
        int res = s.numDecodings("2226252724242221201918171615141311108787876761721201211012111989898911918293");
        System.out.println(res);
    }


}
