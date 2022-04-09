
// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class paint_house {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][3];
        for(int j = 0; j < 3; j++)  {
            dp[costs.length - 1][j] = costs[costs.length - 1][j];
        }
        for(int i = costs.length - 2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][2]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
