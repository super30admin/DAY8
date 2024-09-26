// Time Complexity : O(m*n) where m is number of coins, n is amount
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++)
        {
        
            for(int j=1;j<=amount;j++)
            {
                if(j>=coins[i])
                dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}