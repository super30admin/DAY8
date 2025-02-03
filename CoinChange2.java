// Time complexity:- O(amount * n) where 'amount' is the target amount and 'n' is the number of coin denominations.
// Space complexity:- O(amount) I have used a 1D dp array of size 'amount + 1' to store the number of ways to form each amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Approach: 
 * In this problem, we have to find the number of ways to make up a target amount using a given set of coin denominations.
 * I used dynamic programming and initialized a dp array where dp[i] stores the number of ways to form amount i. 
 * For each coin, I updated the dp array by adding the ways to form amounts that include the current coin,
 * and finally returned the value at dp[amount] as the result. 
 */ 
class Solution {
    public int change(int amount, int[] coins) {

        //dp[i] will store the number of ways to make up the amount 'i' using the given coins
        int[] dp = new int[amount+1];

        // There is one way to make amount 0, which is using no coins
        dp[0] = 1;

        // Iterate over each coin in the 'coins' array
        for (int i=0;i<coins.length;i++) {
            // For each coin, iterate through all possible amounts from 1 to 'amount'
            for (int j=1;j<dp.length;j++) {
                // If the current amount 'j' is less than the coin's value, we can't use this coin for the amount 'j'               
                if (j < coins[i]) {
                    dp[j] = dp[j]; // No update needed; this amount can't be formed with this coin
                } else {
                    // If the current amount 'j' is greater than or equal to the coin's value,
                    // update dp[j] to include combinations that use the current coin
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        // Return the number of ways to make the target 'amount'
        return dp[dp.length-1];
    }
}
