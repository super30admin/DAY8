//Time Complexity: O(n)
//Space Complexity: O(n*3) = O(N)

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length==0)
            return 0;
        int n = costs.length-1;
        int[][]dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];        
        
        for(int i=1;i<dp.length;i++)
        {
                dp[i][0] = costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2] = costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
}