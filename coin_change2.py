class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if  len(coins)==0 and amount==0:
            return 1
        dp=[[0 for i in range((amount)+1)] for j in range (len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0]=1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+(dp[i][j-coins[i-1]])
        return dp[-1][-1]
                
        
        