//time O(n) n is size of coins array
//space O(n)

class Solution {
    public int change(int amount, int[] coins) {
        int c = coins.length;
        int[][] dp = new int[c+1][amount+1];
        // Arrays.fill(dp[0][], 0);
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        dp[0][0] = 1;
        for(int i = 1; i <= c; i++) {
            for(int j = 0; j <= amount; j++) {
                //till amount is less that coins
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[c][amount];
    }
}
