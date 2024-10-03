// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class Solution {
    public int Change(int amount, int[] coins) {
        int m = coins.Length;
        int n = amount;
        // can be solved with 1D or 2D array
        int[] dp = new int[n+1];

        dp[0]= 1;
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j >= coins[i-1]){
                    dp[j] = dp[j]+dp[j-coins[i-1]];

                }  
                
            }
        }
        return dp[n];
    }
}