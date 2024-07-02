/*
    1. Time Complexity : O(m*n) - m - number of coins, n - amount
    2. Space Complexity :Memoization - O(m*n), Tabulation - O(n)    
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */

import java.util.Arrays;
class Solution {
    static int[][] dp;
    public static int helper(int[] coins, int idx, int amount) {
        if (amount==0) return 1;
        if (amount <0 || idx == coins.length) return 0;
        if (dp[idx][amount] != -1) return dp[idx][amount];
        dp[idx][amount] = helper(coins, idx + 1, amount) + helper(coins, idx, amount - coins[idx]);
        return dp[idx][amount];
    }
    public static int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for (int i = 0;i < coins.length; ++i)
            Arrays.fill(dp[i], -1);
        return helper(coins, 0, amount);
    }
    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i <= n;++i)
            dp[i][0] = 1;
        for (int i = 1;i <= n; ++i){
            for(int j = 1;j<= amount; ++j){
                dp[i][j] = dp[i-1][j];
                if (j >= coins[i-1])
                    dp[i][j] += dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }
    public static int change3(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i){
            for (int j = 1 ; j <= amount; ++j) {
                if (j>=coins[i-1])
                    dp[j] += dp[j - coins[i-1]];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 4992;
        System.out.println("Using Memoization -- Number of Combinations for amount:"+ amount +" is:"+change(amount, coins));
        System.out.println("Using Tabulation with O(m*n) space -- Number of Combinations for amount:"+ amount +" is:"+change2(amount, coins));
        System.out.println("Using Tabulation with O(n) space -- Number of Combinations for amount:"+ amount +" is:"+change3(amount, coins));
    }
}