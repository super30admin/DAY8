// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        int n = amount+1;
        int m = coins.length+1;
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<m;i++){
            for(int j = 0; j<n;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int helper(int i, int amount, int[] coins){
        if(amount == 0) return 1;
        if(amount<0 || i>=coins.length) return 0;
        return helper(i, amount-coins[i], coins) + helper(i+1, amount, coins);
    }
}