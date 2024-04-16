## Problem2 (https://leetcode.com/problems/coin-change-2/)

# Approach
# Create a matrix with rows as coins+1 len and columns as amount from 0 to given amount. Set 1st column to 1 and 1st row except 1st index to 0
# Traverse through the matrix from 1 to end and for every index, add the no. of ways so far(above cell) with count x places back in the same row where x is actual value of the coin
# This approach works as we have already computed the no. of ways for previous element and we are adding the number of ways when we use this coin


# Time Complexity: O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        dp = []

        for i in range(m+1):
            row = []
            for j in range(n+1):
                row.append(0)
            dp.append(row)
        
        for i in range(m+1):
            dp[i][0] = 1
        
        print(dp)

        for i in range(1,m+1):
            for j in range(1,n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[-1][-1]