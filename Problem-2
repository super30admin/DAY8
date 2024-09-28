class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        m = len(coins)
        n = amount
        dp = [[0] * (amount + 1) for _ in range(m + 1)]
        dp[0][0] = 1
        
        
        for i in range(1, m+1):
            for j in range(amount + 1):
                if j - coins[i -1] < 0:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][n]