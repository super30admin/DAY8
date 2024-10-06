# Time Complexity = O(m*n)  | Space Complexity = O(m*n)


class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        dp = [[0 for i in range(m)] for j in range(n)]

        cost_r = costs[m - 1][0]
        cost_b = costs[m - 1][1]
        cost_g = costs[m - 1][2]

        for j in range(m - 2, -1, -1):
            temp_r = cost_r
            temp_b = cost_b
            cost_r = costs[j][0] + min(cost_b, cost_g)
            cost_b = costs[j][1] + min(temp_r, cost_g)
            cost_g = costs[j][2] + min(temp_r, temp_b)

        return min(cost_r, min(cost_b, cost_g))
