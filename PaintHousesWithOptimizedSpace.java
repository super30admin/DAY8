// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterating backwards through the houses and updating the minimum costs for each color,
// while only storing the last calculated values for the previous house's colors to save space.

public class PaintHousesWithOptimizedSpace {
    public int minCost(int[][] costs) {
        int n = costs.length;

        int varR = costs[n - 1][0];
        int varB = costs[n - 1][1];
        int varG = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            int tempR = varR;
            varR = costs[i][0] + Math.min(varB, varG);
            int tempB = varB;
            varB = costs[i][1] + Math.min(tempR, varG);
            varG = costs[i][2] + Math.min(tempR, tempB);
        }
        return Math.min(varR, Math.min(varB, varG));
    }
}
