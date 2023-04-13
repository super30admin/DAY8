/* Problem statement
There are a row of n houses, each house can be painted with one of the three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...

Return the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example 1:
Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Example 2:
Input: costs = [[7,6,2]]
Output: 2

Constraints:

costs.length == n
costs[i].length == 3
1 <= n <= 100
1 <= costs[i][j] <= 20









*/



//Brute Force

class Solution {
    public int minCost(int[][] costs) {
        return minCostHelper(costs, 0, -1, 0);
    }
    
    private int minCostHelper(int[][] costs, int house, int prevColor, int totalCost) {
        if (house == costs.length) return totalCost;
        
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != prevColor) {
                minCost = Math.min(minCost, minCostHelper(costs, house+1, i, totalCost+costs[house][i]));
            }
        }
        return minCost;
    }
}


//Improved with Dynamic Programming

class Solution{
  public int minCost(int[][] costs) {
    int n = costs.length;
    int[][] dp = new int[n][3];

    // Initialize the first row of dp with the costs of painting the first house
    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];

    // For each house, calculate the minimum cost of painting that house with each color
    for (int i = 1; i < n; i++) {
        dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
    }

    // Return the minimum cost of painting the last house with each color
    return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
  }
}
