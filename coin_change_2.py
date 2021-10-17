#Time Complexity : O(mn)
#Space Complexity : O(mn) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [ [0]*(amount+1) for i in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 1
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
      
        return dp[len(coins)][amount]
        