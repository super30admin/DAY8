# 256. Paint House
#Submitted by atharva
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)

        dp = [[0] * 3 for _ in range(n)]

        dp[0] = costs[0]

        for house in range(1,n):
            dp[house][0] = costs[house][0] + min(dp[house-1][1], dp[house-1][2])
            dp[house][1] = costs[house][1] + min(dp[house-1][0], dp[house-1][2])
            dp[house][2] = costs[house][2] + min(dp[house-1][0], dp[house-1][1])
        
        return min(dp[-1])

        