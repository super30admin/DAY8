// Time Complexity : O(n) n = no of rows in costs
// Space Complexity : O(n) n = no of rows in costs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N0

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length<1){
            return 0;
        }
        
        int[][] dp = new int[costs.length][costs[0].length];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }
        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
    }
}