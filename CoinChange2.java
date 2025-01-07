/**
 * Time Complexity: O(mn) where m is the number of coins and n is the amount.
 * Space Complexity: O(mn) where m is the number of coins and n is the amount.
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this: No
 * 
 */

class CoinChange2 {

  public int change(int amount, int[] coins) {
    if (coins == null || coins.length == 0) {
      return 0;
    }

    int[][] dp = new int[coins.length + 1][amount + 1];
    for (int i = 0; i <= coins.length; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j < coins[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          int case1 = dp[i - 1][j];
          int case2 = dp[i][j - coins[i - 1]];
          dp[i][j] = case1 + case2;
        }
      }
    }
    return dp[coins.length][amount];
  }

}
