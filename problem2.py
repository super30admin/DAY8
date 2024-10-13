# Approach 1 - Recursive
# time complexity: O(2^n)
# space complexity: O(n)
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:

#         return self.helper(amount, coins, 0)
        
#     def helper(self, amount: int, coins: List[int], i: int) -> int:
#         # base case
#         if amount<0 or i>=len(coins):
#             return 0
#         if amount==0:
#             return 1

#         # logic
#         case0 = self.helper(amount, coins, i+1)

#         case1 = self.helper(amount-coins[i], coins, i)

#         return case0+case1

# ---------------------------------------------------------------------------------------------

# Approach 2 - Dynamic Programming (2D Array)
# time complexity: O(m*n)
# space complexity: O(m*n)
# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         m = len(coins)
#         n = amount

#         import numpy as np
#         dp = np.zeros((m+1, n+1), dtype=int)

#         dp[0][0] = 1

#         for i in range(1, m+1):
#             for j in range(0, n+1):
                
#                 # if amount is smaller than coin
#                 if j<coins[i-1]:
#                     # import from above cell
#                     dp[i][j] = dp[i-1][j]
#                 else:
#                     dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
#         return dp[m][n]

# ---------------------------------------------------------------------------------------------

# Approach 3 - Dynamic Programming (1D Array)
# time complexity: O(m*n)
# space complexity: O(n)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        import numpy as np
        # dp = np.zeros((m+1, n+1), dtype=int)
        dp = np.zeros(n+1, dtype=int)

        dp[0] = 1

        for i in range(1, m+1):
            for j in range(0, n+1):
                
                if j>=coins[i-1]:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
                    
        return dp[n]