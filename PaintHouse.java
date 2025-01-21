// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length;

        // Bottom-up dynamic programming
        for (int i = 1; i < n; i++) {
            // Update the cost for each color at house i
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]); // Red
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]); // Blue
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]); // Green
        }

        // Return the minimum cost of painting the last house
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
    
}
