# The code defines a minCost method to find the minimum cost of painting houses such that no two adjacent houses have the same color.
# The costs for each house are given in a 2D list, where costs[i][0], costs[i][1], and costs[i][2] represent the cost of painting the ith house red, blue, and green, respectively.

# Dynamic Programming Iteration:
#   - Starting from the second house (index 1), the cost to paint each house a specific color is updated by adding the minimum cost of painting the previous house a different color.
#   - For each house 'i':
#       - costs[i][0] (cost to paint house 'i' red) is updated with the minimum of the costs of painting the previous house blue or green.
#       - costs[i][1] (cost to paint house 'i' blue) is updated with the minimum of the costs of painting the previous house red or green.
#       - costs[i][2] (cost to paint house 'i' green) is updated with the minimum of the costs of painting the previous house red or blue.
#   - This ensures that the running minimum cost for each color choice is carried forward without painting consecutive houses the same color.

# Final Result:
#   - The minimum value in costs[-1] (the last house's costs) represents the minimum cost to paint all houses with no two adjacent houses sharing the same color, which is returned.

# TC: O(n) - The time complexity is linear as each house is processed once.
# SC: O(1) - The space complexity is constant as the costs list is updated in place without additional data structures.


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(1, len(costs)):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])

        return min(costs[-1])