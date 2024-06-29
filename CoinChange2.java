// Time Complexity : O(mn)
// Space Complexity : 2D - O(mn), 1D - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2D array
/*
class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0 || coins == null) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i<coins.length+1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i<coins.length+1; i++) {
            for(int j = 1; j<amount+1; j++) {
                if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
*/

// 1D array
class Solution {
  public int change(int amount, int[] coins) {
    if(coins.length == 0 || coins == null) return 0;
    int[] dp = new int[amount+1];
    dp[0] = 1;
    for(int coin: coins) {
      for(int j = coin; j<amount+1; j++) {
        dp[j] = dp[j] + dp[j-coin];
      }
    }
    return dp[amount];
  }
}