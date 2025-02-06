// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * 
 * We used dp and create 2d array as we have 2 decision variables.
 * If amount is 0 then coins are not used so input 0.
 * If coins can be found to get that amount then return max integer, so input max integer for coins of denomination 0.
 * At any location in the matrix, number of coins = minimum of (1+dp[i][j-coins[i-1]](denomination chosen), dp[i-1][j](denomination not chosen).
 * We return dp[m][n] because we want number of coins considering all coins and total amount given.
 */

class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        int m =coins.length;
        int n = amount;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}


/*
class Solution {
    public int change(int amount, int[] coins) {
        int m =coins.length;
        int n = amount;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(coins[i-1]<=j){
                    dp[j]=dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}
*/
