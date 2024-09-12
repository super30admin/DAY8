// Time Complexity : O(n*m) n = coins, m = amount
// Space Complexity : O(n) n = coins
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length<1 || coins == null){
            return -1;
        }
        int dp[][] = new int [coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j]+ dp[i][j - coins[i - 1]];
            }
        }
       int result = dp[coins.length][amount]; 
        return result;
    }
}