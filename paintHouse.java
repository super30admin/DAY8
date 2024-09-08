//time O(mn) m is rows n is columns
//space O(mn)


class Solution {
    /*
    [17,2, 17]
    [16,16, 5]
    [14, 3,19]
    */ 
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) dp[i][j] = costs[i][j] + Math.min(dp[i+1][1], dp[i+1][2]);
                if(j == 1) dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][2]);
                if(j == 2) dp[i][j] = costs[i][j] + Math.min(dp[i+1][0], dp[i+1][1]);
            }
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
