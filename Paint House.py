class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        if costs == None or len(costs) == 0:
            return 0

        n = len(costs)

        

        dp = [[0 for i in range(3)] for i in range(n)]
        # dp = [([0] * 3)] * n
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]
        # print(dp)

        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])

        # print(dp)
        return min(dp[0][0],dp[0][1],dp[0][2])

        



        