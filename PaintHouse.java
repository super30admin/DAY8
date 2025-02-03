// Time complexity:- 
// Space complexity:- 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Approach: 
 *  In this question, we have to find the minimum cost of painting a row of houses with three colors,
 *  ensuring no two adjacent houses have the same color. I initialized the DP table by setting the costs for painting the last house with each color. 
 *  Then, we iterate from the second-to-last house to the first, updating the minimum cost for each house based on the color choices for the next house. 
 *  Finally, we return the minimum cost of painting the first house with any of the three colors.
 */ 

class Solution {
    public int minCost(int[][] costs) {

        // Get the number of houses
        int n = costs.length;

        // Create a DP table to store the minimum cost for each house and color
        int dp[][] = new int[n][3];

        //Initialize the last house's cost for each color
        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        // Loop through the houses from second last to the first one
        for(int i = n-2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]); // Red: Next house can be Blue or Green
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]); // Blue: Next house can be Red or Green
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]); // Green: Next house can be Blue or Red
        }

        // The final result is the minimum cost to paint all houses starting from house 0
        // The first house can be painted in any of the three colors, so we take the minimum of them
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));

    }
}
