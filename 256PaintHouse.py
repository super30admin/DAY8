# Time Complexity is O(n), Space complexity is also O(n)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return -1
        n = len(costs)
        dp = [[0 for i in range(3)] for j in range(n)]
        for i in range(3):          #Copy first row costs as it is
            dp[0][i] = costs[0][i]
        # print(dp)
        for i in range(1, n):
            dp[i][0] = costs[i][0] + min(dp[i-1][1],dp[i-1][2])
            dp[i][1] = costs[i][1] + min(dp[i-1][0],dp[i-1][2])
            dp[i][2] = costs[i][2] + min(dp[i-1][0],dp[i-1][1])

        return min(dp[-1][0],dp[-1][1],dp[-1][2])
