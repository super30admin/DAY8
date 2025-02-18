// Time Complexity : O(m*amount) n is the size of the input coins array
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // There's one way to make amount 0, which is by not using any coins.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // There's no way to make positive amounts with zero coins.
        for (int i = 1; i <= amount; i++) {
            dp[n][i] = 0;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[n][amount];
    }
}