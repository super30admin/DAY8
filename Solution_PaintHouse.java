//TC: O(m x 3)
//SC: O(m x 3)
//Did it run on leetcode: Yes
public class Solution_PaintHouse {
    public int minCost(int[][] costs) {
        int r = costs.length;
        int c = costs[0].length;
        int[][] dp = new int[r][c];
        dp[r-1][0] = costs[r-1][0];
        dp[r-1][1] = costs[r-1][1];
        dp[r-1][2] = costs[r-1][2];
        for(int i = r-2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}
