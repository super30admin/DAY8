// Problem 256. Paint House
// Time Complexity : O(n) n is the number of houses
// Space Complexity : O(1) costR, costB, costG, prevCostR, prevCostB, and prevCostG
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
public class MinCost {
    public int minCost(int[][] costs) {
        int n = costs.length;

        if (n == 0) return 0;

        // Initial costs for the last house
        int costR = costs[n-1][0];
        int costB = costs[n-1][1];
        int costG = costs[n-1][2];

        // Fill the DP array from the second last house to the first house
        for (int i = n-2; i >= 0; i--) {
            int prevCostR = costR;
            int prevCostB = costB;
            int prevCostG = costG;

            costR = costs[i][0] + Math.min(prevCostB, prevCostG);
            costB = costs[i][1] + Math.min(prevCostR, prevCostG);
            costG = costs[i][2] + Math.min(prevCostR, prevCostB);
        }

        // The answer is the minimum cost to paint all houses
        return Math.min(costR, Math.min(costB, costG));
    }
}
