class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs) 
        n = len(costs[0])
        
        if not costs:
            return 0
        
        dp = [[0]*n for _ in range(m)]
        
        for j in range(n):
            dp[m-1][j] = costs[m-1][j]
            
        
        for i in range(m-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
            
        
        return min(dp[0][0],dp[0][1],dp[0][2])
    