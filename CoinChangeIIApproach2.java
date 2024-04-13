// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn how to corelate with the Recursion solution

/*
 * Approach-2 with DP
 * Since the above approach is not doing any memoization, and we have identified
 * subproblems we can optimize using DP
 * - Base case dp[0][0]=1
 * - j<amount> < coins[i-1] <coin>
 * 
 * - if amount is less than the coin we have.. we cannot choose the coin to get
 * the value for the same amount with out using this coin.
 * i.e., one row above, same column (amount)
 * 
 * - if amount is greater or equal to than the coin.. we can choose this coin to
 * create the amount, so the total number of comibinations we can get to the
 * amount is not using the coin (always an option) which is one row above same
 * column + the sub-problem we already solved at
 * j-coins[i-1] - subproblem at index :: amount(j) - coin value( coins[i-1]) ->
 * gives the column where our sub problem lies
 * 
 * 
 * 
 * Questions: why choose i=1 & j=0 for starting the loop?
 */

public class CoinChangeIIApproach2 {

    public int change2(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[m][n];

    }
}