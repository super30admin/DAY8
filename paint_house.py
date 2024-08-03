# TIme complexity = O(m*n)
# Space complexity = O(1)
# tested on leetcode
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        color = len(costs[0])
        dp = [[0]*(3) for i in range(n)]
        for i in range(3):
            print(dp[n-1][i], costs[n-1][i])
            dp[n-1][i] = costs[n-1][i]
        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        return min (dp[0][0], dp[0][1], dp[0][2])
