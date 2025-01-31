//The idea here is at each node, we are finding the sum of the results that come from both it's child nodes
//one child subtree is if the don't consider the coin, the other child subtree is if the consider the coin
//we are using 2d array for tabulation because the result is dependent on 2 variables
//dummy row is considered because we need to calculate the first row values
//TC: O(m*n) where m is the number of coins, and n is the amount
//SC: O(m*n) for 2d array
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 1; i<=m; i++){
            for(int j = 0; j<=n; j++){
                //denomination > current amount
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
    return dp[m][n];//not writing any base case because, if no combinations exist, then returns 0 by default as we set those earlier
    }
}