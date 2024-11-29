# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)

class Solution:
   
    def change(self, amount: int, coins: List[int]) -> int:
        if amount==0:
            return 1
        dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        for i in range(len(dp)):
            if i==0:
                dp[0][i]=1
            else:
                dp[0][i]=0
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                
            
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
            
    
        
        return dp[-1][-1]