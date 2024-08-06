class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;

        int[][] dp = new int [m+1][amount+1];

        dp[0][0] = 1;

        for (int i = 1; i <= m; i++){
            for( int j = 0; j <= amount; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[m][amount];
    }
}
