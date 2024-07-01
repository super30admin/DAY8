"""
## Problem2 (https://leetcode.com/problems/coin-change-2/)
"""

# Approach_1: Greedy with 2^N TC AND SC

class Solution:
    def helperCoinChange(self, coins, amount, idx):
        #base case
        if (amount == 0):
            return 1 
        
        if (amount < 0 or idx == len(coins)):
            return 0
        
        #Logic
        # chosse the coin
        case_1 = self.helperCoinChange(coins, amount - coins[idx], idx)
        # Not choose the coin
        case_2 = self.helperCoinChange(coins, amount, idx + 1)
        
        return case_1 + case_2
    
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helperCoinChange(coins, amount, 0)
        
        
# Approach_2 : DP matrix TC=O(m*n) SC=O(m*n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins : return 0
        
        col = amount + 1
        row = len(coins) + 1
        
        coinMatrix = [[0 for _ in range(col)] for i in range(row)]
              
        for r in range(row):
            coinMatrix[r][0] = 1
            
        for r in range(1, row):
            for c in range(1, col):
                
                # if the amount is less then the coin denomination
                if (c < coins[r - 1]):
                    coinMatrix[r][c] = coinMatrix[r - 1][c]
                    
                else:
                    coinMatrix[r][c] = coinMatrix[r-1][c] + coinMatrix[r][c - coins[r - 1]]
                    
        return coinMatrix[row - 1][col - 1]
        