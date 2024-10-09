// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int change(int amount, int[] coins) {
        // return helper(coins, amount, 0, 0);
        int m = coins.length;
        int n = amount;
        int dp[] = new int[n+1];
        dp[0] = 1; 

        for(int i = 1; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                //amount is lesser than the dinominator
                if(j < coins[i - 1]){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] + dp[j- coins[i - 1]];
                }
            }
        }
        return dp[n];
    }
}