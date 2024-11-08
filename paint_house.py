"""
TC: O(n) n number of houses
SP:O(1) RGB color is fixed and same list is updated every iteration
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [0,0,0]
        for i in range(len(costs)):
            prev_red, prev_blue, prev_green = dp
            dp[0] = costs[i][0]+ min(prev_blue, prev_green)
            dp[1] = costs[i][1]+ min(prev_red, prev_green)
            dp[2] = costs[i][2]+ min(prev_blue, prev_red)
        return min(dp)