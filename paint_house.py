"""
DP-2

Problem1(https://leetcode.com/problems/paint-house/)

There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses 
such that no two adjacent houses have the same color.

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
 
Constraints:
costs.length == n
costs[i].length == 3
1 <= n <= 100
1 <= costs[i][j] <= 20

Time Complexity : O(n) where n is no of houses i.e., len(costs)
Space Complexity : O(1) because we're storing previous results in variables which is constant.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Since we're having repeatitive sub problems we're going to store them by creating a dp 2D array of size n (length of costs i.e., no of houses) x 3 (no of colors). But since there are only 3 colors instead of storing
them in dp array we can keep track of them through the variables red, green, blue. Now Idea is we're going to start iterating from the last second row and we're going to store our last row values in red, blue and green respective
variables. Now while iteration we check the minimum cost we if take current red which is cost[i][0] and min of previous blue & green values. Since the red will be updated here we're going to store the red in temp before applying this
operation. Similary we're going to calculate the minimum costs for blue & red. After the iteration we get the final values in respective variables & we check min amoung them & return it as a result.
"""

# Approach 1 - modifying given input
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs) == 0:
            return 0

        for i in range(len(costs) - 2, -1, -1):
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])

        return min(costs[0][0], costs[0][1], costs[0][2])
    

# Approach 2 new space for 2D arrays
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0:
            return 0

        dp = [[0] * 3 for _ in range(len(costs))]
        n = len(costs)

        for j in range(3):
            dp[n-1][j] = costs[n-1][j]
        
        for i in range(len(costs) - 2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

        return min(dp[0][0], dp[0][1], dp[0][2])


# Approach 3 without extra space       
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs) == 0:
            return 0
            
        n = len(costs)
        red = costs[n-1][0]
        blue = costs[n-1][1]
        green = costs[n-1][2]

        for i in range(len(costs) - 2, -1, -1):
            temp_red = red
            red = costs[i][0] + min(blue, green)
            temp_blue = blue
            blue = costs[i][1] + min(temp_red, green)
            green = costs[i][2] + min(temp_red, temp_blue)

        return min(red, blue, green)


        

        
        