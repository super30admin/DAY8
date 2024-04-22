// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length + 1; //Calc the row
        int n = amount + 1; //Cal the col
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j < coins[i - 1]){ //If the amount is less the denomination
                    dp[i][j] = dp[i-1][j]; //Then take the coin from row - 1
                } else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j - coins[i-1]]); //Otherwise add the prev value from the row and the coins from the row above
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}