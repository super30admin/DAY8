// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach: 
 */

public class HousePaintingRecursive {

    public int minCost(int[][] costs) {
        int houseIndex = 0;
        int chooseR = helper(costs, houseIndex, 0, 0);
        int chooseB = helper(costs, houseIndex, 1, 0);
        int chooseG = helper(costs, houseIndex, 2, 0);

        return Math.min(chooseG, Math.min(chooseB, chooseR));
    }

    private int helper(int[][] costs, int i, int color, int totalCost) {

        // base case
        if (i >= costs.length)
            return totalCost;

        // logic

        if (color == 0) {// RED
            int chooseB = helper(costs, i + 1, 1, totalCost + costs[i][color]); // we are adding here.
            int chooseG = helper(costs, i + 1, 2, totalCost + costs[i][color]);
            totalCost = Math.min(chooseG, chooseB); // I thought i am not adding anything here..

        } else if (color == 1) { // BLUE
            int chooseR = helper(costs, i + 1, 0, totalCost + costs[i][color]);
            int chooseG = helper(costs, i + 1, 2, totalCost + costs[i][color]);
            totalCost = Math.min(chooseG, chooseR);
        } else { // Green
            int chooseR = helper(costs, i + 1, 0, totalCost + costs[i][color]);
            int chooseB = helper(costs, i + 1, 1, totalCost + costs[i][color]);
            totalCost = Math.min(chooseB, chooseR);
        }

        return totalCost;

    }
}