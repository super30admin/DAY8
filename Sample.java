// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Time complexity :O(m*n)
// Space complexity;O(m*n)
// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length+1][amount+1];

        for(int j=0;j<coins.length+1;j++) {
            dp[j][0] = 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        for (int i=1;i<coins.length+1;i++) {
            for (int j=1;j<amount+1;j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }

            }
        }
        return dp[coins.length][amount];
        
    }
}

//Time complexity :O(n)
// Space complexity;O(1)

class Solution {
    public int minCost(int[][] costs) {


        for (int i=costs.length-2;i>=0;i--) {
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        
    }
}
