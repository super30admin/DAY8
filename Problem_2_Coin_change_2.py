# APPROACH 1: BRUTE FORCE (RECURSIVE SOLUTION) 
# Time Complexity : O(2 ^ (t / min(n))), n : len(nums), t: target
# Space Complexity : O(t / min(n))
# Did this code successfully run on Leetcode : NO (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : NONE
#
#
# Your code here along with comments explaining your approach
# 1. Its a recursive solution with arguments - coins, remaining amount, index, count of ways
# 2. base case: if remaining amount is 0, inc count of ways by 1 and return it
# 3. 2 cases- dont choose the coin -> call recursively with args - coins, remaining amount, index + 1, count of ways
#              choose the coin -> call recursively with args - coins, remaining amount - current coin value, index (as we can cjoose the same coin), count of ways

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0:
            return 1
        
        return self.helper(coins, amount, 0, 0)
    
        
    def helper(self, coins, remaining_amount, ind, count_ways):
        
        if remaining_amount < 0 or ind == len(coins):
            return 0
        
        if remaining_amount == 0:
            count_ways += 1
            return count_ways
        
        # NOT CHOOSE THE COIN
        case_1 =  self.helper(coins, remaining_amount, ind + 1, count_ways)
    
        # CHOOSE THE COIN
        case_2 =  self.helper(coins, remaining_amount - coins[ind], ind, count_ways)

        return case_1 + case_2



# APPROACH 2: DYNAMIC PROGRAMMING
# Time Complexity : O(nt), n: len(coins) and t: amount
# Space Complexity : O(nt)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Store all the solutions in 2d matrix, of size amount * len(coins). The first column will be 1 as there's no way to reach up to 0 amount (counted as one way) and the first
#    row is 0 as there's no way with 0 denomination to reach the amount
# 2. for each cell - if target (column) < denomination (row) -> then previous row's value (as we can't make use of this new denomination)
#                   if target >= denomination -> previous rows value + number of ways to get target - denomination
# 3. Result is the last cell value of the matrix


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[None for _ in range(amount + 1)] for _ in range(len(coins) + 1)]
        
        for row in range(len(dp)):
            dp[row][0] = 1
            
        for column in range(1, len(dp[0])):
            dp[0][column] = 0
            
            
        for row in range(1, len(dp)):
            for column in range(1, len(dp[0])):
                
                if column < coins[row - 1]:
                    dp[row][column] = dp[row - 1][column]
                    
                else:
                    dp[row][column] = dp[row - 1][column] + dp[row][column - coins[row - 1]]
                    
        return dp[-1][-1]
        
        
        
        
        
# APPROACH 3: DYNAMIC PROGRAMMING (SPACE COMPLEXITY IMPROVED)
# Time Complexity : O(nt), n: len(coins) and t: amount
# Space Complexity : O(t)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach (SAME APPROACH AS APPROACH 2)
# 1. Store all the solutions in 1d array, of size amount. The array is initialised as (1st element as 1) and rest as 0.
# 2. Do this for len(coins) times, for each cell - if target (column) < denomination (row) -> do nothing
#                                                   if target >= denomination -> cell's value + number of ways to get target - denomination
# 3. Result is the last cell value of the array

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [0 for _ in range(amount + 1)] 
        dp[0] = 1
             
        for ind in range(0, len(coins)):
            for column in range(1, len(dp)):
                
                if column >= coins[ind]:
                    dp[column] += dp[column - coins[ind]]
                    
        return dp[-1]
