// Time Complexity : O(coins.length*amount)
// Space Complexity : O(coins.length*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length+1][amount+1];
        for(int[] rows : dp)
            Arrays.fill(rows,-1);
        return helper(coins, amount, coins.length);
    }
    public int helper(int [] coins, int amount,int n)
    {
        if(amount == 0)
            return 1;
        if(n == 0)
            return 0;
        if(dp[n][amount]!=-1)
            return dp[n][amount];
        if(coins[n-1]<=amount)
            return dp[n][amount] = helper(coins,amount-coins[n-1],n) + helper(coins,amount,n-1);
        else
            return dp[n][amount] =  helper(coins,amount,n-1);
    }
}