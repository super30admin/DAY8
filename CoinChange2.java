// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class CoinChange2 {
    // 2D array
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1 ; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // till the denominator is less than amount its the no choose case or 0 case
                if(j < coins[i-1]) {
                    dp[i][j]  = dp[i-1][j];
                }

                else {
                    //when denominator is equal to or greater than amount, choose and no choose case
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        // return last cube of the matirx;
        return dp[m][n];

    }

    // Time Complexity : O(m*n)
    // Space Complexity : O(n)
    // 1D Array
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for(int i = 1 ; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // till the denominator is less than amount its the no choose case or 0 case
                if(j < coins[i-1]) {
                    dp[j]  = dp[j];
                }

                else {
                    //when denominator is equal to or greater than amount, choose and no choose case
                    dp[j] = dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        // return last cube of the matirx;
        return dp[n];

    }


}