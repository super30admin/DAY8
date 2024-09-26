//Time complexity: O(n*m) 
//Space complexity: O(n*m)
//n-> no. of coins of different value,  m-> total amount

class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length+1][amount+1];
        for(int i=0; i<coins.length+1; i++) // With any denomination we can make sum=0 in just one way
            dp[i][0]=1;
        for(int i=1; i<=amount; i++) // With no coins we can make any sum in 0 ways.
            dp[0][i]=0;
        for(int i=1; i < dp.length; i++)    
        {
            for(int j=1; j<dp[0].length; j++)
            {
                dp[i][j]=dp[i-1][j]+(j >=coins[i-1]? dp[i][j-coins[i-1]]:0);    //Total ways=Number of ways we made sum without using current denomination + using current denomination if the total sum is greater than or equal to the sum.
            }
        }
        return dp[coins.length][amount];
    }
}