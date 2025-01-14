# The approach uses dynamic programming with O(n) time complexity, where n is the number of houses.  
# A 2D DP table stores the minimum cost to paint each house, avoiding adjacent houses with the same color.  
# The result is the minimum value in the first row, representing the least cost to paint all houses.  

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == None:
            return 0
        
        n = len(costs)
        dp = [[0 for i in range(3)] for j in range(n)]
        print(dp)
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]

        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        
        return min(dp[0][0], dp[0][1], dp[0][2])