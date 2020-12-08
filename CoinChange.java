// Time Complexity : O(m * n) , m = number of coins + 1, n = amount + 1
// Space Complexity : O(m * n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int change(int amount, int[] coins) {
        
        if(coins == null) {
            return 0;
        }
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        int m = dp.length;
        int n = dp[0].length;
        
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        
        return dp[m - 1][n - 1];
     }
}