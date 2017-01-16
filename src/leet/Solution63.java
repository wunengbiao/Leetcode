package leet;

/**
 * Created by wunengbiao on 2017/1/6.
 */
public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        boolean pass = true;
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] != 1 && pass) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
                pass = false;
            }
        }

        pass = true;
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] != 1 && pass) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
                pass = false;
            }
        }

//        dp[0][0]=1;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1 || (dp[i - 1][j] == 0 && dp[i][j - 1] == 0))
                    dp[i][j] = 0;
                else if (dp[i - 1][j] != 0 && dp[i][j - 1] == 0) dp[i][j] = dp[i - 1][j];
                else if (dp[i - 1][j] == 0 && dp[i][j - 1] != 0) dp[i][j] = dp[i][j - 1];
                else if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows - 1][cols - 1];

    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] nums2 = {{1, 0}};

        int[][] nums3 = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        Solution63 s = new Solution63();

        System.out.println(s.uniquePathsWithObstacles(nums));

    }
}
