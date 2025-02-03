//MEMOIZATION
/* Time Complexity: O(m*n) where m - number of coins, n - amount
 * Space Complexity: atmost we solve m*n subproblems O(m*n).
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: O(m*n) where m - number of coins, n - amount
 * Space Complexity: atmost we solve m*n subproblems O(m*n). But can be optimized to O(n) as we are just using two rows at any time.
 * Leetcode: yes
 * Any Problems: no
 */

import java.util.Arrays;

public class CoinChange2 {
    //MEMOIZATION
     private int helper(int index, int target, int[] coins, int[][] dp)
    {
        if(target==0)
            return 1;
        if(index<0 || target<0)
            return 0;
        if(dp[index][target] != -1)
            return dp[index][target];

        int case1 = helper(index, target-coins[index], coins, dp);
        int case2 = helper(index-1, target, coins, dp);

        dp[index][target] = case1 + case2;

        return dp[index][target];
    }
    public int changeMemoization(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++)
        Arrays.fill(dp[i], -1);
        return helper(coins.length-1, amount, coins, dp);
    }


    //TABULATION
    public int changeTabulation(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0; i<coins.length; i++)
            dp[i][0] = 1;
        
        for(int i=0; i<coins.length; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(i==0)
                {
                    if(j>=coins[i])
                        dp[i][j] = dp[i][j-coins[i]];
                    else
                        dp[i][j] = 0;
                }
                else
                {
                    if(j>=coins[i])
                        dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}
