class Solution {
    public int change(int amount, int[] coins) {
        // Edge case: if no coins are provided
        if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }
        
        // Initialize DP table
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // Base case: There is one way to make amount 0 (use no coins)
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the DP table
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        // Return the result from the last cell
        return dp[coins.length][amount];
    }
}