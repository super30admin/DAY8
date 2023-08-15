// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {

        if (coins==null || coins.length==0) return -1;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m ;i++)
        {
            for(int j=0;j<=n ;j++)
            {
                if(j< coins[i-1])
                dp[i][j]= dp[i-1][j];
                else
                dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[m][n];
    }
}