//Time Complexity : O(nm)
//Space Complexity : O(nm)
// did you try it on leetcode : yes

class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
            return 0;
        int[][] dp = new  int[coins.length+1][amount+1];
        
        //fill first coloumn
        for(int i = 0; i<= coins.length ; i++)
            dp[i][0] = 1;
        
        for(int i = 1; i<= coins.length ; i++)
        {
            for(int j = 1; j<=amount ; j++)
            {
                //denomination>amount
                if(coins[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}