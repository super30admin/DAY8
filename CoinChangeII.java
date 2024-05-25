// Time Complexity : O(m * n) where m = length of coins array , n = amount
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// logic : The code implements a dynamic programming solution to count the number of combinations that can make up a given amount of money using the provided coins denominations.
// we create a 2D array, dp, where dp[i][j] represents the number of combinations to make amount j using the first i coins.
// We iterate through each coin and each possible amount, updating dp[i][j] based on whether including the current coin or not.
// Finally,  return dp[coins.length][amount], which holds the total number of combinations.

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];
        for(int i =0; i< coins.length+1 ; i++){
            dp[i][0] = 1;
        }
        for(int i =1; i< coins.length+1; i++){
            for(int j = 1; j< amount+1 ; j++){
                if( j < coins[i-1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}