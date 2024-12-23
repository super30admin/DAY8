# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;
    int n = costs.length;
    int k = costs[0].length;
    int[][] memo = new int[n][k];
    int minCost = Integer.MAX_VALUE;
    for (int color = 0; color < k; color++) {
      minCost = Math.min(minCost, dfs(costs, memo, 0, color));
    }

    return minCost;
  }

  private int dfs(int[][] costs, int[][] memo, int houseNumber, int color) {
    // 1. end
    if (houseNumber == costs.length - 1) {
      return costs[houseNumber][color];
    }

    if (memo[houseNumber][color] > 0) {
      return memo[houseNumber][color];
    }

    int minCost = Integer.MAX_VALUE;
    for (int nextColor = 0; nextColor < costs[0].length; nextColor++) {
      if (color == nextColor)    continue;
      int curCost = dfs(costs, memo, houseNumber + 1, nextColor);
      minCost = Math.min(curCost, minCost);
    }

    int totalCost = costs[houseNumber][color] + minCost;
    memo[houseNumber][color] = totalCost;
    return totalCost;
  }
}

             

## Problem2 (https://leetcode.com/problems/coin-change-2/)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        
        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]
        
        return dp[amount]

