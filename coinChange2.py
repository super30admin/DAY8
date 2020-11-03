class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        n = len(coins)
        dp=[[0 for i in range(amount+1)] for j in range(n+1)]
        
        dp[0][0] = 1
        m = len(dp[0])
        n = len(dp)
        for i in range(n):
            dp[i][0]=1
        
        for i in range(1,n):
            for j in range(1,m):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
            
        return dp[n-1][m-1]