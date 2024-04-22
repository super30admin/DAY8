// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length; //Calc the row
        int[][] dp = new int[n][3]; //Initiate the matrix with the row and the col is the number of colors

        for(int j = 0; j <= 2; j++){ //Initialize the dp matrix with the initial cost matrix
            dp[n - 1][j] = costs[n - 1][j];
        }

        for(int i = n - 2; i >= 0; i--){
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]); //Calc from the end of the matrix to get the minimum cost
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][2], dp[i+1][0]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}