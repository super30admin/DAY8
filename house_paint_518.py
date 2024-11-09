class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # Get the number of houses
        num_houses = len(costs)

        # Initialize a 2D array to store minimum costs for each house and color combination
        dp = [[0, 0, 0] for _ in range(num_houses)]

        # Initialize the costs for the first house
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        # Iterate over the houses starting from the second one
        for i in range(1, num_houses):
            # Calculate the minimum cost for painting the current house with each color
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]  # Red
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]  # Green
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]  # Blue

        # Return the minimum cost of painting all houses
        return min(dp[-1])