// Time Complexity :O(N) n- number of house 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length; // Number of houses

        // Initialize the minimum costs for the last house
        int colorR = costs[n - 1][0]; // Cost of painting the last house red
        int colorB = costs[n - 1][1]; // Cost of painting the last house blue
        int colorG = costs[n - 1][2]; // Cost of painting the last house green

        // Iterate from the second last house to the first house
        for (int i = n - 2; i >= 0; i--) {
            // Store the current values of colorR, colorB, and colorG in temporary variables
            int tempR = colorR;
            int tempB = colorB;

            // Update the minimum costs for painting the current house with each color
            colorR = costs[i][0] + Math.min(colorB, colorG); // Paint current house red
            colorB = costs[i][1] + Math.min(tempR, colorG); // Paint current house blue
            colorG = costs[i][2] + Math.min(tempB, tempR); // Paint current house green
        }

        // Return the minimum cost of painting the first house with any color
        return Math.min(colorR, Math.min(colorB, colorG));
    }
}
