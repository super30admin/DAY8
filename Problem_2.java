// Time Complexity : O(nxm)
// Space Complexity : O(nxm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//518. Coin Change II
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) return -1;
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j < coins[i -1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}