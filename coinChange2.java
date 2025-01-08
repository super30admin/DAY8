// Problem : (https://leetcode.com/problems/coin-change-2/)
//Recursion or Exhaustive Approach:
//TC: will get time limit exceeded
class coinChange2 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        return recurse(amount, coins, 0);
    }

    private int recurse(int amount, int[] coins, int index) {
        // base
        if (index == coins.length || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        // logic
        // zero case or don't pick coin
        int case1 = recurse(amount, coins, index + 1);
        // One case or we pick a coin
        int case2 = recurse(amount - coins[index], coins, index);
        return case1 + case2;

    }
}
//DP

//Coin Change II
public class Solution {

    // time complexity: O(n*m)
    // space complexity: O(n*m)
    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return 0;
        }

        int dp[][] = new int[coins.length + 1][amount + 1];
        // fill the zero row
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        // filling the one row
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        // creating dat nested loop
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}