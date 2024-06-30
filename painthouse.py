#time = O(n) 
#space = O(n) 

def minCost(costs):
    if not costs:
        return 0
    
    n = len(costs)
    
    # dp[i][j] will represent the minimum cost to paint up to the i-th house with color j
    dp = [[0] * 3 for _ in range(n)]
    
    # Initialize the first house's cost
    dp[0][0] = costs[0][0]
    dp[0][1] = costs[0][1]
    dp[0][2] = costs[0][2]
    
    # Fill the dp array
    for i in range(1, n):
        dp[i][0] = costs[i][0] + min(dp[i-1][1], dp[i-1][2])  # Cost of painting house i red
        dp[i][1] = costs[i][1] + min(dp[i-1][0], dp[i-1][2])  # Cost of painting house i blue
        dp[i][2] = costs[i][2] + min(dp[i-1][0], dp[i-1][1])  # Cost of painting house i green
    
    # The answer is the minimum cost to paint the last house with any color
    return min(dp[-1][0], dp[-1][1], dp[-1][2])

# Example usage
costs = [
    [17, 2, 17],
    [16, 16, 5],
    [14, 3, 19]
]

print(minCost(costs))  # Output: 10