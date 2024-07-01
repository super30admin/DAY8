# time: O(n)
# space: O(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [0,0,0]


        for i in range(0, len(costs)):
            dp0 = costs[i][0] + min(dp[1], dp[2])
            dp1 = costs[i][1] + min(dp[0], dp[2])
            dp2 = costs[i][2] + min(dp[0], dp[1])

            dp = [dp0, dp1, dp2]
        print(dp)
        return min(dp)
        