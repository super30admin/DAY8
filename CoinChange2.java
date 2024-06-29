// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* At each subproblem we have two cases, wether to choose the current coin or not. We have two variables at each step, the denominations of coins available and the total sum to be made 
  At each step/iteration we find the  number of ways to make that sum with the subset of denominations available. 
  We also consider  two cases, when we dont choose the coin, the number of ways to reach the total remain same as the previous subset, when we choose the coin, the number of ways is the sum of previous subset  plus the minimum found with same subset for (total - current coin denomination)
  The final element in the matrix gives the answer. */


public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];

        if(amount == 0) return 1;
        if(coins.length == 1) {
            if(amount == coins[0]) return 1;
            else if(amount < coins[0]) return 0;
        }

        dp[0][0] = 1;
        for(int i =1;i<=m;i++){     //O(m)
            dp[i][0] = 1;
        }
         

        for(int i=1;i<=m;i++){          //O(m*n)
            for(int j= 1;j<=n;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] + dp[i][j - coins[i-1]];
                } 
            }
        }

        int result = dp[m][n];
        return result;
    }
}