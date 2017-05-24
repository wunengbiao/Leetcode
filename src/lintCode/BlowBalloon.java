package lintCode;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/4.
 * 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。
 * 每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
 * left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。
 * 要求吹爆所有气球，得到最多的分数。
 * 样例给出 [4, 1, 5, 10]   返回 270
 * nums = [4, 1, 5, 10] burst 1, 得分 4 * 1 * 5 = 20
 * nums = [4, 5, 10]    burst 5, 得分 4 * 5 * 10 = 200
 * nums = [4, 10]       burst 4, 得分 1 * 4 * 10 = 40
 * nums = [10]          burst 10, 得分 1 * 10 * 1 = 10
 * 总共的分数为 20 + 200 + 40 + 10 = 270
 */
public class BlowBalloon {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<nums.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int len = 0; len < n; len++) {
            for(int i = 0; i < n - len; i++) {
                int j = i + len;
                for(int k = i; k <= j; k++) {
                    int l = i > 0 ? nums[i-1] : 1;
                    int r = j < n-1 ? nums[j+1] : 1;
                    int left = k - 1 >= i ? dp[i][k-1] : 0;
                    int right = k + 1 <= j ? dp[k+1][j] : 0;
                    System.out.println("("+i+","+j+"):"+k);
                    System.out.println(l*nums[k]*r + left + right);
                    dp[i][j] = Math.min(dp[i][j], l*nums[k]*r + left + right);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][n-1];
    }
    public static void main(String[] args){
        BlowBalloon s=new BlowBalloon();
        int[] nums={10,1,50,20,5};
        System.out.println(s.maxCoins(nums));
    }
}
