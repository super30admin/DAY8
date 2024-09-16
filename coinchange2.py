# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if len(coins) == 0 and amount == 0:
            return 1
        if len(coins)==0 and amount != 0:
            return 0
        
        n = len(coins)
        
        dp = [[0]*(amount+1)]*(n+1)
        dp[0][0] = 0
        for i in range(1,n+1):
            dp[i][0] = 1
        
        for i in range(1,len(dp[0])):
            dp[0][i] = 0
            
        for i in range(1,n+1):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                
                else:
                    dp[i][j] = dp[i-1][j]+ dp[i][j-coins[i-1]]

        return dp[n][amount]
            
        
        