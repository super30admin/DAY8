//518. Coin Change 2 - https://leetcode.com/problems/coin-change-ii/description/
//Time Complexity: Exponential Time Complexity O(2^(m+n)) where m: number of elements, n: amount

//Recurrsion Approach
class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int amount, int index){
        //valid base case
        if(amount == 0){
            return 1;
        }
        //invalid base case
        if(amount < 0 || index == coins.length){
            return 0;
        }
        //logic
        int choose = helper(coins, amount - coins[index], index);
        int notChoose = helper(coins, amount, index+1);
        //total number of combinations
        return choose + notChoose;
    }
}

//DP Approach
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){
                    //no choose case
                    dp[i][j] = dp[i-1][j];
                }else{
                    //choose case
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[m][n];
    }
}

//DP Approach (Optimized Space Complexity using 1D Array)
//Time Complexity: O(m*n)
//Space Complexity: O(n)
class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        dp[0] = 1;
        //update the same row for each denomination
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){
                    //no choose case
                    dp[j] = dp[j];
                }else{
                    //choose case
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[n];
    }
}