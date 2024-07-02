// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * using a 2D DP, where dp[i][j] represents the number of combinations to make amount j using the first i types of coins.
 *  we initialize dp[i][0] to 1 for all i, indicating one way to make amount 0.
 *  then iterate through each coin and amount combination, updating dp[i][j] based on whether the current coin (coins[i-1]) is included or not.
 *  Finally, return dp[coins.length][amount], which holds the total number of combinations to make the given amount using all types of coins.
 */
class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0)
        {
            return 1;
        }
     
        
        int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0; i<=coins.length; i++)
        {
            dp[i][0]=1;
        }
        
        for(int i=1; i<=coins.length; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(j < coins[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}