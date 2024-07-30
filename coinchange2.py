class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length; // Number of different coins
        int n = amount; // Target amount
        
        // Initialize the DP table with size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the first column (dp[i][0]) with 1 since there's one way to make amount 0: use no coins
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // If the coin's value is greater than the amount, exclude the coin
                } else {
                    // Sum of excluding the coin and including the coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        // The answer will be in dp[m][n]
        return dp[m][n];
    }
}