//Time Complexity: O(n * amount)
//Space Complexity: O(amount) (1D DP array)
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: one way to make amount 0 (choose nothing)

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }
    
}