
//Brute Force
//Space Complexity: O(n)
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
//Time Complexity: O(n)
//Space Complexity: O(n)
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
