//TC: O(m*n) where m is number of coins and n is amount
//SC: O(n)
//Approach: similar to coin change but instead of calculating the minimum number of ways required to calculate forming amount, we calculate total number of ways to form n. dp[i][j] represents number of ways amount j can we formed with first i coins of array.

class Solution {
    public int change(int amount, int[] coins) {
        int m = coins.length; int n = amount;
        int[] dp = new int[n+1];
        dp[0] =1;

        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j>=coins[i-1])
                    dp[j] = dp[j] + dp[j - coins[i-1]];
            }
        }

        return dp[n];
    }
}