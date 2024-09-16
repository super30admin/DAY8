'''
Sol 1:
Memoization:
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a function and traverse recursively every time we see a red do cases for blue and green recurisvely,
every time we see a blue we do red and green and everytime we see a green do red and blue.
Used memoisation pattern to remember if we saw a color at a particular index, if we do see it return it from the dictionary
else calculate it.

Sol2:
Dp Solution
Time Complexity :O(n^2)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a DP 2D array and on each column of a row find the min cost of the alternate indexes and add the current weight
the min of the last row indexes would be the answer.
'''


class Solution:
    def __init__(self):
        self.mem = {}

    def helper(self, costs: List[List[int]], depth, index) -> int:

        if len(costs) == 0 or costs == None:
            return 0

        if (depth, index) in self.mem.keys():
            return self.mem[(depth, index)]

        totalSum = costs[depth][index]

        if depth != len(costs) - 1:

            if index == 0:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 1), self.helper(costs, depth + 1, 2))
            elif index == 1:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 0), self.helper(costs, depth + 1, 2))
            elif index == 2:
                totalSum = totalSum + min(self.helper(costs, depth + 1, 0), self.helper(costs, depth + 1, 1))

        self.mem[(depth, index)] = totalSum

        return totalSum

    def minCost(self, costs: List[List[int]]) -> int:
        case1 = self.helper(costs, 0, 0)
        case2 = self.helper(costs, 0, 1)
        case3 = self.helper(costs, 0, 2)

        return min(case1, case2, case3)

    def dpMinCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        n = len(costs) - 1
        for i in range(1, len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i - 1][1], costs[i - 1][2])
            costs[i][1] = costs[i][1] + min(costs[i - 1][2], costs[i - 1][0])
            costs[i][2] = costs[i][2] + min(costs[i - 1][1], costs[i - 1][0])

        return min(costs[n][0], costs[n][1], costs[n][2])