// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :Yes

class PaintHouse{
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length==0) return 0;
        int n = costs.length;
        int[][] dp = new int[n][3]; 
        dp[n-1][0] = costs[n-1][0]; // Filling up last row as it is from coin array.
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i = n-2; i >= 0; i--){ // Now starting from second last row.
            dp[i][0] = Math.min(dp[i+1][1], dp[i+1][2]) + costs[i][0]; 
            dp[i][1] = Math.min(dp[i+1][0], dp[i+1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i+1][1], dp[i+1][0]) + costs[i][2];
        }
        return Math.min(dp[0][0], Math.min(dp[0][1],dp[0][2]));
    }
}