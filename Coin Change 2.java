// No. of ways we can make the amount using the coins (Solution using 2D array)
// TC: O(m*n) n: number of coins, m: amount
// SC: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int [n+1][amount+1];
        dp[0][0] = 1;
//        for(int i=1;i<=amount;i++) {
//            dp[0][i] = 0;
//        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                // logic 
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }   
        }
        return dp[n][amount];
    }
}

//No. of ways we can make the amount using the coins (Solution using 1D array)
//TC: O(m*n) n: number of coins, m: amount
//SC: O(m)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int [amount+1];
        dp[0] = 1;
//        for(int i=1;i<=amount;i++) {
//            dp[i] = 0;
//        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                // logic 
                if(coins[i-1] > j)
                    dp[j] = dp[j];
                else
                    dp[j] = dp[j] + dp[j - coins[i-1]];
            }   
        }
        return dp[amount];
    }
}