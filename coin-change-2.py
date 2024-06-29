# // Time Complexity : O(n * m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : just during the base case i was confused weather to return 0 or 1 when amount is 0.

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        n= amount
        m= len(coins)
        dp=[[0 for i in range(n+1)]for j in range(m+1)]
   
        for i in range(m+1):
            dp[i][0]=1
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        
        return dp[m][n]

      
        # Recursive code

        # def helper(coins,amount, idx):
        #     #base

        #     if amount==0:
        #         return 1
        #     if idx>=len(coins) or amount<0:
        #         return 0
        #     take = helper(coins,amount-coins[idx],idx)
        #     notake = helper(coins,amount,idx+1)

        #     return take + notake
        # return helper(coins,amount,0)

#Approach
# we have to find the number of paths/ ways that can give us the amount i.e the combinations.__annotations__
# referring to same approach as coin change 1. the only difference here was that we did not have to caluclate
# the coin itself. but number of ways. 

# by this i mean that the path in the tree where the amount becones 0. that time i increase the count of ways to 1
# which is inturn out base case for the recursive approach. 
# then i drawd the tree and came to know that there are repeated subproblems hence used dp.