// Time Complexity :O(N) n- number of house 
// Space Complexity :O(N)  matrix - n*3--> O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length; // Number of houses

        // DP array to store the minimum cost to paint each house with each color
        int[][] dp = new int[n][3];

        // Initialize the last row of the DP array with the costs of painting the last house
        for (int i = 0; i < 3; i++) {
            dp[n - 1][i] = costs[n - 1][i];
        }

        // Fill the DP array from the second last house to the first house
        for (int i = n - 2; i >= 0; i--) {
            // Cost of painting the current house red plus the minimum cost of painting the next house either blue or green
            dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
            // Cost of painting the current house blue plus the minimum cost of painting the next house either red or green
            dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
            // Cost of painting the current house green plus the minimum cost of painting the next house either red or blue
            dp[i][2] = costs[i][2] + Math.min(dp[i + 1][1], dp[i + 1][0]);
        }

        // Return the minimum cost of painting the first house with any color
        return Math.min(dp[0][2], Math.min(dp[0][0], dp[0][1]));
    }
}
