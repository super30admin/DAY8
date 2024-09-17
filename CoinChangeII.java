/**
 * Time Complexity - O(n*A)  A = Amount n = number of coins
 * Space Complexity - O(A) - A= Amount
 * This code ran on Leetcode
 */

class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i=coin; i <= amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}