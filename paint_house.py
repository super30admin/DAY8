def minCostToPaintHouse(costs):
    if not costs:
        return 0
    
    n, k = len(costs), len(costs[0])
    
    prev_dp = costs[0]
    
    for i in range(1, n):
        curr_dp = [0] * k
        min1, min2 = float('inf'), float('inf')
        for cost in prev_dp:
            if cost < min1:
                min2, min1 = min1, cost
            elif cost < min2:
                min2 = cost

        for j in range(k):
            curr_dp[j] = costs[i][j] + (min2 if prev_dp[j] == min1 else min1)

        prev_dp = curr_dp
    
    return min(prev_dp)
