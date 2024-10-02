def min_Cost(costs):
    m = len(costs)
    n = len(costs[0])

    dp = [[0] * n for _ in range(m)]

    for j in range(m):
        dp[m-1][j] = costs[m-1][j]

    for i in range(m-2,-1,-1):
        dp[i][0] = costs[i][0]+min(dp[i+1][1],dp[i+1][2])
        dp[i][1] = costs[i][1]+min(dp[i+1][0],dp[i+1][2])
        dp[i][2] = costs[i][2]+min(dp[i+1][0],dp[i+1][1])
    print(dp)
    return min(dp[0][0],min(dp[0][1],dp[0][2]))



costs = [[17,2,17],[16,16,5],[14,3,19]]
print(min_Cost(costs))