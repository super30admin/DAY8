# Time Complexity : Add - O(2^n)
# Space Complexity :O(log n)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I have used a Table Approach as described in the lecture
2. The Brute force method didn't run and resulted in maximum depth error in Python
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
            
        if coins == [] and amount ==0:
            return 1
        
        if coins == [] or len(coins) < 1 or amount < 0:
            return 0

        
        rows = len(coins) + 1
        cols = amount + 1
        
        dp = []
        
        for i in range(rows):
            dp.append([0 for j in range(cols)])
            
        dp[0][0] = 1
        
        for i in range(1, rows):
            for j in range(cols):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
                    
        # print (dp)
        
        return dp[rows-1][cols-1]
    
