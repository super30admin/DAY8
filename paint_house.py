class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        m = len(costs)  # Number of houses
        n = len(costs[0])  # Number of colors

        # Initialize dp array to store the minimum cost for each house and color
        dp = [[0] * n for _ in range(m)]

        # Base case: For the last house, the cost is the same as in the input
        for j in range(n):
            dp[m - 1][j] = costs[m - 1][j]

        # Fill the dp table from the second-last house to the first
        for i in range(m - 2, -1, -1):  # Iterate backwards through houses
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])

        # The result is the minimum cost of painting the first house any of the three colors
        return min(dp[0][0], dp[0][1], dp[0][2])


# time complexity is O(m) where M is the number of houses
# space complexity is  O(m) where M is the number of houses
