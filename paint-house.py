# This solution uses dynamic programming to minimize the total painting cost by iterating through each house and updating 
# the cost for painting it each color, considering the minimum cost of the previous house being painted a different color. 
# The final result is the minimum cost of painting the last house with any color.
# Time Complexity:O(N): We are iterating through the costs list once (n times) and performing constant time operations
# within the loop.
# Space Complexity: O(1): We are updating the costs list in place, which means the space complexity is constant 
# (ignoring the input list size). No additional space is used for storing intermediate values.
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n  = len(costs)
        if(n == 0): return 0 
        for i in range(1, n):
            costs[i][0] += min(costs[i-1][1], costs[i-1][2])
            costs[i][1] += min(costs[i-1][0], costs[i-1][2])
            costs[i][2] += min(costs[i-1][0], costs[i-1][1])
        return min(costs[-1])