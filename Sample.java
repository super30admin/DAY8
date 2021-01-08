# DP-2


## Problem2 (https://leetcode.com/problems/coin-change-2/)
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null) return 0;
        int dp[][] = new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}