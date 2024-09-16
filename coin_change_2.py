class Solution:
    def change(self, amount, coins) :
        # Make 2D array with rows -> len(coins) and colums -> range(amount)
        if amount == 0:
            return 1
        dp = [[0 for j in range(amount+1)] for i in range(len(coins)+1)]
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if j == coins[i-1]:
                    dp[i][j] = 1 + dp[i-1][j] + dp[i][j-coins[i-1]]
                elif(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
            
        result = dp[len(dp)-1][len(dp[0]) -1]
        return result