# Approach 1 - Recursive
# Time complexity - O(2^n)
# Space complexity - O(1)
# from typing import List
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         if coins == None or len(coins) == 0:
#             return 0
#         return self.recurse(coins, amount, 0)
    
#     def recurse(self, coins: List[int], amount: int, index: int) -> int:
#         # base
#         if amount < 0 or index >= len(coins): # invalid path
#             return 0
        
#         if amount == 0:
#             return 1

#         # logic
#         case0 = self.recurse(coins, amount, index + 1)
#         case1 = self.recurse(coins, amount - coins[index], index)

#         return case0 + case1
    
# Approach 2 - DP
# Time complexity - O(m * n)
# Space complexity - O(m * n)
from typing import List
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]

        for i in range(len(coins) + 1):
            dp[i][0] = 1
        
        for i in range(1, len(coins) + 1):
            for j in range(1, amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        
        return dp[len(coins)][amount]