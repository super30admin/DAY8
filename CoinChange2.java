// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class CoinChange2 {
    // T = O(m*n)
    //S = O(n)
    //Approach 2: reducing space complexity
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int dp[] = new int[n+1];

        dp[0]=1;
        for(int i =1;i<=m;i++) {
            for(int j=1;j<=n;j++) {

                if(j < coins[i-1]) {
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }

        return dp[n];
    }

    // Time = O(m*n)
    // Space = O(m *n )
    //Approach 1: using matrix and by calculating tabulation
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 1;

        for(int i=1;i<=m ;i++) {
            for(int j=0;j<=n;j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];
    }
}