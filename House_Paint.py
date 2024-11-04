# Explain your approach in three sentences only at top of your code
# Approach: Use dynamic programming to keep track of the minimum cost for each color as we paint each house.
# For each house, calculate the minimum cost for painting it in each color by adding the cost of that color
# to the minimum cost of painting the previous house in a different color.

# Time Complexity: O(n), where n is the number of houses, since we iterate through each house once.
# Space Complexity: O(1), as we modify the input costs array in place without using additional space.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        
        # Starting from the second house, calculate the minimum cost for each color
        for i in range(1, len(costs)):
            # Cost of painting house i red is the cost of painting house i-1 either blue or green
            costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
            # Cost of painting house i blue is the cost of painting house i-1 either red or green
            costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
            # Cost of painting house i green is the cost of painting house i-1 either red or blue
            costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
        
        # The answer is the minimum cost of painting the last house in any of the three colors
        return min(costs[-1])
