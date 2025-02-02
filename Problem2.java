// Time Complexity : O(m*n) where m is the number of coins and n is the amount
// Space Complexity : O(m*n) where m is the number of coins and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We will create a 2D array to store the number of ways to make the amount using the coins

class Problem2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;


        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}