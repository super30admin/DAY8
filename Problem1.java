// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Memoization to compute the cost of picking one color and then selecting the min from the other two colors



class Solution {
    public int minCost(int[][] costs) {
       
        if(costs == null || costs.length == 0) return 0;
        int m = costs.length;
        int[][] dp = new int[m][3];
        for(int j = 0; j < 3; j++) {
            dp[m-1][j] = costs[m-1][j];
        }
        for(int i = m-2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}