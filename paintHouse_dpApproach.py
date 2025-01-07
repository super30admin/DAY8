class solution:
    def paintHouse(costs):
        # TC: O(n)
        # SC: O(n)
        if len(costs) == 0 or costs is None:
            return 0
        n = len(costs) # no of rows
        dp = [[0,0,0] ]* n
        dp[n-1] = costs[n-1]
        
        for i in range(n-2,-1,-1):
            dp[i][0] = costs[i][0]+min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1]+min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2]+min(dp[i+1][0],dp[i+1][1])
            
        print(dp)
        return min(dp[0])
    costs=[[17,2,17],[16,16,5],[14,3,9]]
    print(paintHouse(costs))
    costs=[[7,6,2]]
    print(paintHouse(costs))
