// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        } // setting first column to 1
        for (int i = 1; i < coins.length + 1; i++) {
                int currentCoin = coins[i-1]; // setting the current coin value
            for (int j = 1; j < amount + 1; j++) {
                if (j < currentCoin) { // 0 case
                    dp[i][j] = dp[i - 1][j]; // take the above value
                } else { // 1 case
                    dp[i][j] = dp[i - 1][j] + dp[i][j - currentCoin]; // take the above value + 1 case
                }
            }
        }
        return dp[coins.length][amount]; // return the last element
    }
}