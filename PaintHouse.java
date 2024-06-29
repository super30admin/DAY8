// Time Complexity : O(n)
// Space Complexity : Mutating original matrix - O(1), Using new matrix - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Mutating original matrix:
/*
class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null) return 0;
        for(int i = costs.length-2; i>=0; i--) {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][1], costs[i+1][0]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}
*/

// Using an aditional matrix:
/*
class Solution {
  public int minCost(int[][] costs) {
    // Edge cases.
    if(costs == null || costs.length == 0) return 0;
    // Initialising new matrix
    int[][] dp = new int[costs.length][3];
    int rows = costs.length;
    // Copying elements from the last row
    for(int j = 0; j<3; j++) {
      dp[rows-1][j] = costs[rows-1][j];
    }
    // Calculating the values for the rest of the matrix
    for(int i = rows-2; i>=0; i--) {
      dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
      dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
      dp[i][2] = costs[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
    }
    return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
  }
}
*/

// Using an temporary variables:
class Solution {
  public int minCost(int[][] costs) {
    if(costs == null || costs.length == 0) return 0;
    int rows = costs.length;
    int first = costs[rows-1][0];
    int second = costs[rows-1][1];
    int third = costs[rows-1][2];
    for(int i = rows-2; i>=0; i--) {
      int tempFirst = first;
      int tempSecond = second;
      int tempThird = third;
      first = costs[i][0] + Math.min(tempSecond, tempThird);
      second = costs[i][1] + Math.min(tempFirst, tempThird);
      third = costs[i][2] + Math.min(tempFirst, tempSecond);
    }
    return Math.min(first, Math.min(second, third));
  }
}