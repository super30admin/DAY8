// Time Complexity: O(m * n), where m is the number of coins and n is the amount.
// Space Complexity: O(n), where n is the amount. A 1D array of size (n+1) is used for dynamic programming.
// Approach: Dynamic Programming - Bottom-Up approach. Use a 1D array dp to store the number of combinations to make each amount from 0 to n. Initialize dp[0] to 1, indicating there is one way to make amount 0 (by not choosing any coin). Iterate through each coin and update dp[j] for each amount j from 1 to n, considering two cases: (1) if the current coin denomination is greater than the amount j, the current coin cannot be used, so dp[j] remains the same; (2) otherwise, add the number of combinations dp[j - coins[i-1]] to dp[j], which represents the number of combinations when considering the current coin denomination.
// leetcode link: https://leetcode.com/problems/coin-change-2/

class Solution {
    public int change(int amount, int[] coins) {
       int m = coins.length;
       int n = amount;
       int[] dp = new int[n+1];
       dp[0] =1;

       for(int i=1; i<=m; i++)
       {
           for(int j=0; j<=n; j++)
           {
               //if amount < denomination
               if(j< coins[i-1])
               {
                   dp[j] = dp[j];
               }
               else
               {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
               }
           }
       }
       return dp[n];
    }
}