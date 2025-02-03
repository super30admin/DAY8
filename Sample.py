'''
// Time Complexity :
Problem 1 : O(m*n) where m is the colours and n is the cost
Problem 2 : O(m*n) where m is the coins and n is the amount
// Space Complexity :
Problem 1 : O(m*n) as for the matrix
Problem 2 : O(m*n) as for the matrix
// Did this code successfully run on Leetcode :
Yes the submission ran successfully
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
'''
## Problem 1: Paint House
## Solution 1 - Recursion TIME LIMIT EXCEEDED
# Define a helper fucntion that has inputs as the matrix, row of the cell (colour) and column of 
# the cell (choose red, blue or green).
# When we select the first colour then we calculate the min for the other two colours for the next row
# which ensures that adjacent houses are not painted with the same colour.
# We repeat this for all three colours and get the min values of all, that is the minimum cost to
# paint the house. 
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        reR = self.helper(costs, 0, 0)
        reB = self.helper(costs, 1, 0)
        reG = self.helper(costs, 2, 0)
        return min(reR, min(reG, reG))

    def helper(self, costs, j, i):
        ##base
        if i == len(costs): return 0
        ##logic
        if j == 0:
            ## Red house - next house will be blue or green
            return costs[i][0] + min(self.helper(costs, 1, i+1), self.helper(costs, 2, i+1))
        if j == 1:
            ## Blue house - next house will be red or green
            return costs[i][1] + min(self.helper(costs, 0, i+1), self.helper(costs, 2, i+1))
        if j == 2:
            ## Green house - next house will be blue or red
            return costs[i][2] + min(self.helper(costs, 0, i+1), self.helper(costs, 1, i+1))        

## Solution 2 - Dynamic programming
# Bottom up approach where we populate the last row of the matrix by the color values.
# Add the colour value for every colour combination and update the above row.
# Get the minimum value from the first row which is the min cost to paint the house.
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        n = len(costs)
        dp = [0]*(len(costs[0]))
        dp[n-1][0] = costs[n-1][0]
        dp[n-2][0] = costs[n-2][0]
        dp[n-3][0] = costs[n-3][0]
        for i in range(n-2, 0):
        #Nested for loop if we want to iterate for 'k' colours    
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        return min(dp[0][0], min(dp[0][1], dp[0][2]))

## Problem 2: Coins change to find number of ways to get amount
## Solution 1 - Recursion TIME LIMIT EXCEEDED
# Edge case conditions when the coins array is empty or has no coins then we return 0.
# Create a helper function with input as coins array, index of the coin and the amount. If the amount
# becomes less than equal to '0' or we are at the last coin in the array of coins then return 0.
# Case 0 : We do not choose from the array and iterate over the entire array.
# Case 1: Choose one of the coins from the array and reduce it from the amount to iterate until the 
# amount is <= 0. We will continue iterating over the array.

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if coins == None or len(coins) == 0: return 0
        n = len(coins)
        return self.helper(coins, 0, amount)
    
    def helper(self, coins, idx, amount):
        ##base
        if amount == 0: return 1
        if amount < 0 or idx == len(coins): return 0
        ##logic
        # Do not choose
        case_1 = self.helper(coins, idx+1, amount)
        # Choose
        case_2 = self.helper(coins, idx, amount - coins[idx])
        return (case_1 + case_2)

## Solution 2 - Dynamic programming
# Edge case conditions when the coins array is empty or has no coins then we return 0.
# Create a 2D matrix where the rows represent the amount and the column represents the value of coins.
# We exhaustively search for each amount and coin value and store the iterations in the matrix
# The last row column will have the combinations in which the target amount can be calculated.

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m = len(coins)
        n = amount
        if coins == None: return -1
        dp = [[0 for i in range(n+1)] for j in range(m+1)]

        for i in range(m+1):
            dp[i][0] = 1
        
        for i in range(1, m+1):
            for j in range(1, n+1):
        # If amount is less than coin value we store the previous value of matrix at the current cell   
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
        # We will reduce the amount by the coin value and add the value above this matrix cell
        # as it already will have the recursive calculation output for the previous amount.
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        # Return the last row-column value as it will have the total no. of ways
        return dp[m][n]
    

    
