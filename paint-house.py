# Time Complexity : O(n) - n is len(costs)
# Space Complexity : O(n) - m is len(costs)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Build a matrix to store the min cost for all possible paths
We can either pick red, blue or green for the first house
Min of above 3 will be the answer

To store the repeated sub problems, create matrix of no. of houses x colors(3)
Last row would be same as the input costs last row
From second last row, calculate and store the min cost of choosing red, blue, or green
And keep on doing that till we reach row 0
Min in row 0 will be the answer
"""


def minCost(costs):
    #     chooseRed = self.helper(costs, 0, 0)
    #     chooseBlue = self.helper(costs, 1, 0)
    #     chooseGreen = self.helper(costs, 2, 0)
    #     return min(min(chooseRed, chooseBlue), chooseGreen)

    # def helper(self, costs, colorIndex, rowIndex):
    #     if rowIndex == len(costs):
    #         return 0

    #     if colorIndex == 0:
    #         return costs[rowIndex][colorIndex] + min(self.helper(costs, 1, rowIndex + 1),self.helper(costs, 2, rowIndex + 1))
    #     if colorIndex == 1:
    #         return costs[rowIndex][colorIndex] + min(self.helper(costs, 0, rowIndex + 1),self.helper(costs, 2, rowIndex + 1))
    #     if colorIndex == 2:
    #         return costs[rowIndex][colorIndex] + min(self.helper(costs, 0, rowIndex + 1),self.helper(costs, 1, rowIndex + 1))
    #     return 321321

    if len(costs) == 0:
        return -1

    n = len(costs)
    m = 3

    # create matriz same as size as the input costs
    dp = [[0 for i in range(0, m)] for i in range(0, n)]

    # copy the last row of costs to dp matrix
    for i in range(0, m):
        dp[n - 1][i] = costs[n - 1][i]

    # fill the matrix
    for i in range(n - 2, -1, -1):
        # if picking red house, pick min of (picking blue house, picking green house for next house)
        dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
        # if picking blue house, pick min of (picking red house, picking green house for next house)
        dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
        # if picking green house, pick min of (picking red house, picking blue house for next house)
        dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

    return min(dp[0])



