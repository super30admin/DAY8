# Time complexity - O(m)
# Space complexity - O(m * n)

# Approach - values of DP table are filled with the (cost[R] + min(cost[i-1][G], cost[i-1][B]))
# The min val of the final row is returned 

from typing import List
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [[0 for i in range(3)] for j in range(len(costs))]

        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        n = len(costs)
        for i in range(1, n):
            dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])
        
        return min(dp[n-1][0], dp[n-1][1], dp[n-1][2])