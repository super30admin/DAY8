class Solution:
    def minCost(costs):
        n = len(costs)
        dp = []
        reR = costs [n-1][0]
        reB = costs [n-1][1]
        reG = costs [n-1][2]
        for i in range (n-2, -1,-1):
            tempR=reR
            tempB= reB
            reR = costs[i][0] + min(reB, reG)
            reB =  costs[i][1] + min(tempR, reG)
            reG= costs[i] [2] + min(tempR, tempB)
        return min(reR,min(reB, dp[0][2]))