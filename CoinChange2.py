# Time complexity: O(M * N) N is the number of amounts, and M is the number of denominations
# Space complexity: O(M * N) Dp array needed to store the computed values
# Compiled on leetcode: Yes
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            if amount == 0:
                return 1
            else:
                return 0
        rows = len(coins) + 1
        columns = amount + 1
        
        dp = [[0 for i in range(columns)] for j in range(rows)]
        
        for i in range(1, rows):
            dp[i][0] = 1
        
        for i in range(1, rows):
            for j in range(1, columns):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:    
                    dp[i][j] = dp[i-1][j] + dp[i][j -coins[i-1]]
        
        return dp[rows - 1][columns - 1]
        