//Problem2 (https://leetcode.com/problems/coin-change-2/)

// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/*
 * In this dynamic progamming is used. A 2D array of length coins.length + 1 and amount + 1 is used. Here the pattern goes as follows, until the 
 * value at coins place is less than the amount, fill with the values above row has at that column, else take the sum of the value of above column
 * and the value at coins value spaces back. This sum is taken and calulated for each element space. The value at the end position that is m, n th
 * position gives total number of ways of having the amount. If there are no coins then return 0. If there are coins and amount is 0 then 1 way.
 * A dummy row with coin value 0 is used. 
 */

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return 0;
        if(amount == 0) return 1;
        int m = coins.length; 
        int n = amount;
        int [][]dp = new int[m+1][n+1]; //m+1 n+1 bcz of dummy case and 0 amount case
        for(int i = 0; i<=m;i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j<=n;j++){
            for(int i = 1; i<=m;i++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}