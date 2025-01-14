# The approach uses dynamic programming with O(n * amount) time complexity, where n is the number of coins.  
# A 2D DP table tracks the number of ways to make each amount by including or excluding the current coin.  
# The result is stored in dp[n][amount], representing the total ways to make the given amount.
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == None:
            return 0
        n = len(coins)

        dp = [[0]* (amount+1)] * (n+1)

        for i in range(1, n + 1):
            dp[i][0] = 1
        
        for i in range(1, n+1):
            for j in range(1, amount+1):

                if j<coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[n][amount]
                

        
