"""

There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.


Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Example 2:

Input: costs = [[7,6,2]]
Output: 2

Time Complexity: O(N) 
Space Complexity: O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used dynamic programming to keep track of the minimum cost to paint each house while ensuring no two adjacent houses have the same color.
# At each step, updated the cost of painting the current house with each color by adding the minimum cost of the previous house's other two colors.
# Finally, returned the minimum value from the last house's cost options.


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        dp = [0, 0, 0]

        for i in range(len(costs)):
            dp0 = costs[i][0] + min(dp[1], dp[2])
            dp1 = costs[i][1] + min(dp[0], dp[2])
            dp2 = costs[i][2] + min(dp[0], dp[1])

            dp = [dp0, dp1, dp2]

        return min(dp)
