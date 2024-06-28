// Time Complexity : O(m*n)
// Space Complexity : O(n)

import java.util.Arrays;

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1])
                    dp[j] = dp[j];
                else
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
            }

        return dp[n];
    }
}