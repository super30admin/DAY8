// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// pains houses - tc = O(n), space = O(n)
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        
        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(Math.min(costs[costs.length-1][0],costs[costs.length-1][1]),costs[costs.length-1][2]);
    }
}

//coins change 2
//tc - O(n) SC - O(n)

class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        
        for(int i=1; i<=coins.length; i++){
            for(int j=0; j<=amount; j++){
                if(j==0)
                    dp[i][j] = 1;
                
                else if(j-coins[i-1] >=0)
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount];
    }
}

