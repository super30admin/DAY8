"""
256. Paint House

DP Bottom Up approach --
# TC = O(3xn) = O(n)
# SC = O(n). If we decide to mutate the existing matrix, then SC = O(1)
"""

cost = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]


def paintHouse(costs):
    if costs is None or len(costs) == 0: return -1

    n = len(costs)

    dp = [[None for i in range(3)] for i in range(n)]

    for j in range(n):
        dp[n-1][j] = costs[n-1][j]

    # start from second last row since last row in dp is already filled
    for i in range(n-2, -1, -1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

    return min(dp[0])


if __name__ == '__main__':
    print(paintHouse(cost))
