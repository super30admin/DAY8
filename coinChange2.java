// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class coinChange2 {
        public int change(int amount, int[] coins) {
            if(coins == null || coins.length == 0) return 0;
            
            int[][] dp = new int[coins.length + 1][amount + 1];
            
            //initialize the top row
            for(int j = 1; j < dp.length; j++)
            {
                dp[j][0] = 1;
            }
            
            for(int i = 1; i < coins.length + 1; i++)
            {
                for(int j = 1; j < dp[0].length; j++)
                {
                    //if the amount is less than the denomination
                    if(j < coins[i - 1])
                    {
                        dp[i][j] = dp[i - 1][j];
                    }
                    else
                    {
                        dp[i][j] = dp[i - 1][j] + (dp[i][j - coins[i - 1]]);
                    }
                }
            }
            
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}