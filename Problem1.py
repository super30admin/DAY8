# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)

# Approach
# Initialize the matrix with row as costs and columns as colors. Traverse from bottom to top and set lowest row colors same as given cost matrix.
# From second last row, check for min cost by adding current cost with cost of column except itself. Eg.: for column 0 check sum current value at column 0 with cost in next row at column 1 & 2. Append min value at that index
# Similarly traverse till the first row and return the min cost from the 3 cost in column 0, 1 & 2. 

# Time Complexity: O(3*n) = O(n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp = []

        for i in range(n):
            row = []
            for j in range(3):
                row.append(0)
            dp.append(row)
        
        for j in range(3):
            dp[n-1][j] = costs[n-1][j]

        for i in range(n-2,-1,-1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])

        
        return min(dp[0][0], min(dp[0][1],dp[0][2]))