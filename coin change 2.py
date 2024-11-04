# TC: O(m*n)
# SC: O(m*n)
# The code compiled successfully on LC
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows = len(coins) + 1
        cols = amount + 1
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        dp[0][0] = 1
        for i in range(1, rows):
            for j in range(cols):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[rows-1][cols-1]
