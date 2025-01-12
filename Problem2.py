# Used DP to add iteratively from the last branch of the matrix since we know there are only 3 colors
# Added the minimum term at each row and returned minimum of the 0th row
# TC: O(n)
# SC: O(1)
# TLE for the recursive solution

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0
        n = len(costs)
        for i in range(n - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])
        return min(costs[0][0], costs[0][1], costs[0][2])