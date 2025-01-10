// Time Complexity : O(m*n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int change(int amount, int[] coins) {
        //aesha
        int m = coins.length;
        int n = amount;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=0; i<m; i++)
        {
            for(int j =coins[i]; j<=n; j++)
            {
                
                    dp[j] = dp[j] + dp[j- coins[i]]; 
            }
        }
        return dp[n];
    }
}