// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// calculate number of ways for each row using previous row
// answer will be in last row, last column

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int dp[][] = new int[coins.length +1][amount + 1];
        for(int  i=0; i<coins.length+1; i++){
            dp[i][0 ] = 1;
        }
        for(int i=1; i<=coins.length; i++){
            for(int j = 1; j<=amount; j++){
                if(j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}