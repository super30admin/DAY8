from typing import List


class Solution:

    def dp_approach(self, costs):
        """
        This is dp approach, in the bottom-up manner. The idea is at a given cell in the matrix
        the cost is the minimum of previous row except for the current column.
        time complexity: O(m*3) m is the number of house
        space complexity: O(m*3) matrix
        :param costs: Costs matrix
        :return: min cost
        """
        cols = len(costs[0])
        rows = len(costs)
        dp = [[0 for _ in range(cols)] for _ in range(rows)]

        # fill the dp matrix with the last row of the cost matrix since we are calculating the cost
        # in bottom-up way
        for j in range(cols):
            dp[rows - 1][j] = costs[rows - 1][j]

        # Since the last row is filled, skip it and traverse from bottom up.
        # since the choice is between 2 columns, for simplicity don't use column loop.
        # the total cost of a cell is = its own cost plus minimum among the 2 from the below.
        for i in range(rows - 2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

        return min(dp[0][0], dp[0][1], dp[0][2])

    def brute_force(self, costs, house, color, total):
        """
        Brute force approach: there are three trees possible since the max colors are 3.
        The idea is to find the cost of each tree and return the minimum (For simplicity, this part could
        be done in the main function).
        In the recursive function, for each choice, find the choice made and make the next two
        choices. For example, if house 1 is colored with red, then make the choice of coloring the
         house 2 with blue once and then with green.
         Repeat this for different choice of house 1 color.
         TIme complexity: O(number of trees (3) * 2^n)
         Space complexity: O(n)
        :param costs: Matrix
        :param house: to keep track of house number
        :param color: to keep track of color
        :param total: to keep track of total color
        :return: total cost
        """
        # base case: when no more house left to color (rows)
        if house >= len(costs):
            return total

        # logic: first find which color is used to paint house 1
        if color == 0:
            # make the next choice to color the house with other 2 colors
            cost1 = self.brute_force(costs, house + 1, color + 1, total + costs[house][color])
            cost2 = self.brute_force(costs, house + 1, color + 2, total + costs[house][color])
            return min(cost1, cost2)
        if color == 1:
            cost1 = self.brute_force(costs, house + 1, color - 1, total + costs[house][color])
            cost2 = self.brute_force(costs, house + 1, color + 1, total + costs[house][color])
            return min(cost1, cost2)
        if color == 2:
            cost1 = self.brute_force(costs, house + 1, color - 1, total + costs[house][color])
            cost2 = self.brute_force(costs, house + 1, color - 2, total + costs[house][color])
            return min(cost1, cost2)

    def minCost(self, costs: List[List[int]]) -> int:
        costR = self.brute_force(costs, 0, 0, 0)
        costB = self.brute_force(costs, 0, 1, 0)
        costG = self.brute_force(costs, 0, 2, 0)

        ans = min(costR, costB, costG)
        return ans
