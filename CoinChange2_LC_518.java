// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// (https://leetcode.com/problems/coin-change-2/)
// Algo:

import java.util.Arrays;

/**
 * Greedy Approach:
 * Fail Case 1: [2, 5] amount = 6
 * 1 * 5 = 5, amount = 6 - 5 = 1
 * 2 > 1 -> -1 (not possible case)
 * 
 * Fail Case 2: [5, 10, 20, 25], amount = 40
 * 1 * 25 = 25, amount = 40 - 25 = 15
 * 1 * 10 = 10, amount = 15 - 10 = 5
 * 1 * 5 = 5, amount = 5 - 5 = 0
 * ----------------------------------
 * total coins = 3
 * found 1 possible combo (not the best possible answer)
 * 
 * we need to find ALL possible combos.
 * 
 * Hence, Greedy fails.
 * So, go exhaustive and explore all possible solutions using recursion.
 */
public class CoinChange2_LC_518 {

    /**
     * Exhaustive Approach using recursion.
     * TC: O(2 ^ (m + n)), i.e., exponential
     * m = amount
     * n = # of coins
     * 
     * eg: coins = [1, 2], amount = 10
     * pick [1] till amount = 10 --> 10 levels
     * not pick [1] till no coins left --> n levels
     * 
     * Therefore, O(2 ^ (m + n))
     * 
     * NOTE: at each step, we have 2 branches (pick | not pick).
     * And the total levels = m + n
     * Hence, the # of nodes == # of fxn calls = O(2 ^ (m + n))
     * 
     * SC: O(m + n) i.e. stack space
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_recursion(int[] coins, int amount) {
        int combos = coinChange_recursion(coins, coins.length - 1, amount);
        return combos;
    }

    private int coinChange_recursion(int[] coins, int coin, int amount) {
        // base
        if (amount == 0) {
            return 1;
        }
        if (coin == 0) {
            return amount % coins[coin] == 0 ? 1 : 0;
        }
        // logic
        int pick = 0;
        if (coins[coin] <= amount) {
            pick = coinChange_recursion(coins, coin, amount - coins[coin]);
        }
        int notPick = coinChange_recursion(coins, coin - 1, amount);
        return pick + notPick;
    }

    /**
     * Memoization: Due to overlapping sub-problems.
     * 
     * TC: O(m * n)
     * SC: O(m * n) + O(m + n) i.e. stack space
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_memoization(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int combos = coinChange_memoization(dp, coins, coins.length - 1, amount);
        return combos;
    }

    private int coinChange_memoization(int[][] dp, int[] coins, int coin, int amount) {
        // base
        if (amount == 0) {
            return 1;
        }
        if (coin == 0) {
            return amount % coins[coin] == 0 ? 1 : 0;
        }
        if (dp[coin][amount] != -1) {
            return dp[coin][amount];
        }
        // logic
        int pick = 0;
        if (coins[coin] <= amount) {
            pick = coinChange_memoization(dp, coins, coin, amount - coins[coin]);
        }
        int notPick = coinChange_memoization(dp, coins, coin - 1, amount);
        return dp[coin][amount] = pick + notPick;
    }

    /**
     * Tabulation: Avoids aux. stack space
     * 
     * TC: O(m * n)
     * SC: O(m * n)
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // base
        // if(coin == 0) {
        // return amount % coins[coin] == 0 ? 1 : 0;
        // }
        for (int amt = 1; amt <= amount; amt++) {
            dp[0][amt] = amt % coins[0] == 0 ? 1 : 0;
        }

        // base
        // if(amount == 0) {
        // return 1;
        // }
        for (int coin = 0; coin < n; coin++) {
            dp[coin][0] = 1;
        }

        for (int coin = 1; coin < n; coin++) {
            for (int amt = 1; amt <= amount; amt++) {
                // logic
                int pick = 0;
                if (coins[coin] <= amt) {
                    pick = dp[coin][amt - coins[coin]];
                }
                int notPick = dp[coin - 1][amt];
                dp[coin][amt] = pick + notPick;
            }
        }

        int combos = dp[coins.length - 1][amount];
        return combos;
    }

    /**
     * Space Optimization: Converts 2D matrix to 1D array
     * 
     * TC: O(m * n)
     * SC: O(m)
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_spaceOptimization(int[] coins, int amount) {
        int n = coins.length;
        int[] curr = new int[amount + 1];
        int[] prev = new int[amount + 1];

        // base
        // if(coin == 0) {
        // return amount % coins[coin] == 0 ? 1 : 0;
        // }
        for (int amt = 1; amt <= amount; amt++) {
            prev[amt] = amt % coins[0] == 0 ? 1 : 0;
        }

        // base
        // if(amount == 0) {
        // return 1;
        // }
        prev[0] = 1;

        for (int coin = 1; coin < n; coin++) {
            curr[0] = 1;
            for (int amt = 1; amt <= amount; amt++) {
                // logic
                int pick = 0;
                if (coins[coin] <= amt) {
                    pick = curr[amt - coins[coin]];
                }
                int notPick = prev[amt];
                curr[amt] = pick + notPick;
            }
            prev = Arrays.copyOf(curr, amount + 1);
        }

        int combos = prev[amount];
        return combos;
    }

}