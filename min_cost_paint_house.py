def min_cost_paint_house(costs):

    if not costs:
        return 0

    n = len(costs)
    dp = costs[0][:]

    for i in range(1, n):
        # Calculate the cost for each color
        prev_dp = dp[:]
        dp[0] = costs[i][0] + min(prev_dp[1], prev_dp[2])
        dp[1] = costs[i][1] + min(prev_dp[0], prev_dp[2])
        dp[2] = costs[i][2] + min(prev_dp[0], prev_dp[1])

    return min(dp)

# Time Complexity: O(n) where n is the number of houses.
# Space Complexity: O(1) as we use a fixed array to store the costs for each color.
