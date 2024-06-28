// Time Complexity :O(coins.length * amount). M*N
// Space Complexity :O(n). O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length; // Number of coin types
        int n = amount; // Target amount
        int[] dp = new int[n + 1]; // DP array to store the number of ways to make each amount
        dp[0] = 1; // There is 1 way to make amount 0 (by using no coins)
     
        // Iterate over each coin type
        for (int i = 1; i <= m; i++) {
            // Iterate over each amount from 1 to target amount
            for (int j = 1; j <= n; j++) {
                // If the current coin value is greater than the target amount,
                // we cannot include this coin. So, we keep the value as it is.
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } 
                // If we can include the coin, we add the number of ways to make the remaining amount
                else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        // The answer is the number of ways to make the amount using all the coin types
        return dp[n];
    }
}
