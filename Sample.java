// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// building color
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
       
        
        int [][] dp = new int[n][3];

        dp[n-1][0] = costs[n-1][0];
        dp[n-1][1] = costs[n-1][1];
        dp[n-1][2] = costs[n-1][2];

        for(int i = n-2; i >= 0; i--) {
            dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
        }
        return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    }
}


//----------------------------------------------------//

//coin change 2
class Solution {
    public int change(int amount, int[] coins) {

        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        if(coins== null) return 0;
        

        for(int i=1;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] =dp[i-1][j] + dp[i][j-coins[i-1]];
                }          
            }

        }
         return dp[m][n];  
    }
}
