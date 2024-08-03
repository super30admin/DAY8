#Approach: Tabulation
#TC:O(n) n is the number of houses and m here is constant basically the number of colors
#SC:O(n)

class Solution:
    def solve(self, costs):
        if not costs:
            return 0
        
        n=len(costs)
        #create dummy row
        dp = [[0] * 3 for _ in range(n)]
        #fill it same as last row costs
        dp[n-1][0]=costs[n-1][0]
        dp[n-1][1]=costs[n-1][1]
        dp[n-1][2]=costs[n-1][2]
        #now iterate from bottom to top
        for i in range(n-2, -1,-1):
            #cost at that position+min of remaning others 
            dp[i][0] = costs[i][0]+min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1]+min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2]+min(dp[i + 1][0], dp[i + 1][1])
        #return min from topmost row 
        return min(dp[0][0],dp[0][1],dp[0][2])