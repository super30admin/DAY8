# Time: O(n*m)
# Space: O(n*m)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [[0]* len(costs[0]) for i in range(len(costs))]
        dp[0] = costs[0]
        for j in range(1, len(costs)): #houses
            for i in range(len(costs[0])): #colors
                if i == 0:
                    dp[j][i] = min(costs[j][i] + dp[j-1][i+1], costs[j][i] + dp[j-1][i+2])
                elif i == len(costs[0])-1:
                    dp[j][i] = min(costs[j][i] + dp[j-1][i-1], costs[j][i] + dp[j-1][i-2])
                else:
                    dp[j][i] = min(costs[j][i] + dp[j-1][i+1], costs[j][i] + dp[j-1][i-1])
        return min(dp[-1])