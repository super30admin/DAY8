# time complexity: O(n)
# space complexity: O(n)
def paintHouse(costs):
    n = len(costs)
    # create dp
    dp = [[0] * 3 for _ in range(n)]
    dp[n-1][0] = costs[n-1][0]
    dp[n-1][1] = costs[n-1][1]
    dp[n-1][2] = costs[n-1][2]
    # fill the dp matrix bottom up with min from [i+1] 
    for i in range(n-2,-1,-1):
        dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][1],dp[i+1][0])
    return min(dp[0][0],min(dp[0][1],dp[0][2]))

costs = [
        [17, 2, 17],  # Costs for painting the first house
        [16, 16, 5],  # Costs for painting the second house
        [14, 3, 19]   # Costs for painting the third house
    ]
result = paintHouse(costs)
print(paintHouse(costs))