# Problem 23: coin change II: (https://leetcode.com/problems/coin-change-2/)

# Time Complexity : O(m * n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# Take a dp matrix of size m+1 * n+1 where m = len(coins) and n= amount and initiate it to 0's
# for amounts lesser than the coin we take the above value from the matrix, else
# take the sum of above value + that coins[i-1] plaves left from the same row and return dp[m][n]

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins) 
        n = amount 
        dp = [[0] * (n+1) for _ in range(m+1)]
        dp[0][0]=1
        for i in range(1,m+1):
            for j in range(0,n+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
         
        return dp[m][n]


# memoization

class Solution:
    def __init__(self):
        memo = []
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        self.memo = [[-1] * (n+1) for _ in range (m)] 
        return self.helper(coins, 0, amount)
    
    def helper(self, coins: List[int], idx: int, amount: int) -> int:
        if(amount < 0 or idx == len(coins)):
            return 0
        if (amount == 0): 
            return 1
        if (self.memo[idx][amount] != -1):
            return self.memo[idx][amount]
        case1 = self.helper(coins,idx,amount - coins[idx])
        case2 = self.helper(coins,idx+1,amount)
        self.memo[idx][amount] = case1 + case2
        return self.memo[idx][amount]



        


        
