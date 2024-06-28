// Time Complexity :O(N) n- number of house
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    int[][] memoDp; // Memoization array to store results of subproblems

    public int minCost(int[][] costs) {
        // Initialize the memoization array
        this.memoDp = new int[costs.length][3];
        
        // Calculate the minimum cost starting with each of the three colors
        int costR = helper(costs, 0, 0); // Starting with red
        int costB = helper(costs, 0, 1); // Starting with blue
        int costG = helper(costs, 0, 2); // Starting with green
        
        // Return the minimum of the three costs
        return Math.min(costR, Math.min(costB, costG));
    }

    int helper(int[][] costs, int houseIdx, int currentColor) {
        // Base case: If all houses are painted, return 0 cost
        if (houseIdx == costs.length) return 0;
        
        // If we already have a calculated cost for this subproblem, return it
        if (memoDp[houseIdx][currentColor] != 0) return memoDp[houseIdx][currentColor];

        // Calculate the cost of painting the current house with the current color
        if (currentColor == 0) {
            // If current color is red, calculate the cost and the minimum cost of painting the next house with either blue or green
            memoDp[houseIdx][currentColor] = costs[houseIdx][0] + Math.min(helper(costs, houseIdx + 1, 1), helper(costs, houseIdx + 1, 2));
        } else if (currentColor == 1) {
            // If current color is blue, calculate the cost and the minimum cost of painting the next house with either red or green
            memoDp[houseIdx][currentColor] = costs[houseIdx][1] + Math.min(helper(costs, houseIdx + 1, 0), helper(costs, houseIdx + 1, 2));
        } else if (currentColor == 2) {
            // If current color is green, calculate the cost and the minimum cost of painting the next house with either red or blue
            memoDp[houseIdx][currentColor] = costs[houseIdx][2] + Math.min(helper(costs, houseIdx + 1, 1), helper(costs, houseIdx + 1, 0));
        }

        // Return the calculated cost for the current house and color
        return memoDp[houseIdx][currentColor];
    }
}
