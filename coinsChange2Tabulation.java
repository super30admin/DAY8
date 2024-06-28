// Time Complexity :O(coins.length * amount).   M*N
// Space Complexity :O(coins.length * amount). M*N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, 

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length; // Number of coin types
        int n = amount; // Target amount
        int[][] dp = new int[m + 1][n + 1]; // DP table to store the number of ways to make each amount

        // Initialize the dp array with base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // There is 1 way to make amount 0 (by using no coins)
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current coin value is greater than the target amount,
                // we cannot include this coin. So, we take the value from the previous row.
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } 
                // If we can include the coin, we take the sum of:
                // 1. Not including the coin (value from the previous row)
                // 2. Including the coin (value of the remaining amount after including the coin)
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        // The answer is the number of ways to make the amount using all the coin types
        return dp[m][n];
    }
}
