// Overall Time Complexity : O(m*n) . The m*n is number of elements in the matrix.
// Overall Space Complexity : O(m*n) . The space complexity is the size of the matrix.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem involves finding the number of ways to make the target amount using the given coin denominations.
// Iterate over each coin and update the dp table by considering including or excluding the coin.

class CoinChange {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        dp[0][0] =1;

        for(int i =1;i<=m;i++){
            for(int j = 0;j<=n;j++){
                //denomination of the coin > amoount
                if( coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                 }

            }
        }
        return dp[m][n];
    }
}