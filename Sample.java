// Problem1(https://leetcode.com/problems/paint-house/)
// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used dynamic programming to solve this problem. I have iterated over the houses array and for each house, I have updated the cost of painting the house with the minimum cost of painting the previous house with a different color. Finally, I have returned the minimum cost of painting the last house.
class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}

// Problem 2: (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O(n*m) where n is the amount and m is the number of coins
// Space Complexity : O(n) where n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach : I have used
// dynamic programming to solve this problem. I have created a dp array of size
// amount + 1. I have initialized the first element of dp array to 1. I have
// iterated over the coins array and for each coin, I have iterated over the dp
// array and updated the dp array. I have updated the dp array by adding the
// value of dp[j] and dp[j - coins[i - 1]] if j >= coins[i - 1] else I have
// updated the dp array by dp[j]. Finally, I have returned the last element of
// the dp array.
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < coins[i - 1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
                }
            }
        }
        return dp[n];
    }
}