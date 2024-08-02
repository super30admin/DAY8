// Time Complexity: O(n * m)
// Space Complexity: O(n)
// Coin Change II

class Solution {
    public int change(int amount, int[] coins) {
        // Initialize the dp array with size amount + 1
        int[] dp = new int[amount + 1];
        
        // There is exactly one way to make amount 0: use no coins
        dp[0] = 1;

        // Iterate over each coin denomination
        for (int coin : coins) {
            // Update the dp array for each amount from coin to the total amount
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        // The answer is the number of ways to make up the amount
        return dp[amount];
    }
}