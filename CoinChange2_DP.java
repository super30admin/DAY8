// Time Complexity : O(mn) --> where m is amount and n is length of array
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode (518): Yes
// Any problem you faced while coding this : No

// Explanation: In this 'Coin Change' problem, we are creating a 2D array of size numeber of coins and amount size. We are then traversing over this 2D array to compute the number of combinations that make up that amount and storing this information for future use cases. In this way we are eliminating the computation of similar sub-cases (like we had in using recurssion method). And in each index we are taking the addition of both the cases i.e. (1) to choose a coint or (2) to not choose the coin. Going with this method, we are able to solve the problem in linear time i.e. O(mn).

// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        
        int dp[][] = new int[coins.length + 1][amount + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j - coins[i - 1]];
            }
        }
        
        return dp[dp.length-1][dp[0].length - 1];
    }
}