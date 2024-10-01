
# Approach:
# For each color select the minum of other color in the adjacent color and add to present color


# complexities
#Time Complexity : O(m*n)
#Space Complexity : o(1)

class Solution:

    def minCost(self,costs):
        costR=self.helper(costs,0,0,0)
        costB= self.helper(costs,0,1,0)
        costG= self.helper(costs,0,2,0)
        return min(costR,costB,costG)

    def helper(self, costs,index,color,total_sum):
        if index>= len(costs):
            return total_sum

        if color==0:
            return min(self.helper(costs,index+1,1,total_sum+costs[index][0]),self.helper(costs,index+1,2,total_sum+costs[index][0]))
        elif color==1:
            return min(self.helper(costs,index+1,0,total_sum+costs[index][1]),self.helper(costs,index+1,2,total_sum+costs[index][1]))
        else:
            return min(self.helper(costs,index+1,1,total_sum+costs[index][0]),self.helper(costs,index+1,1,total_sum+costs[index][2]))

class Solution:

    def minCost(self,costs):
        m = len(costs)
        n = len(costs[0])

        dp = [[0  for _ in range(n)]for _ in range(m)]
        for j in range(n):
            dp[m-1][j] = costs[m-1][j]

        for i in range(m-2,-1,-1):
            dp[i][0]=costs[i][0]+min(dp[i+1][1],dp[i+1][2])
            dp[i][1]=costs[i][1]+min(dp[i+1][0],dp[i+1][2])
            dp[i][2]=costs[i][2]+min(dp[i+1][0],dp[i+1][1])
        return min(dp[0][1],dp[0][0],dp[0][2])

class Solution:

    def minCost(self,costs):
        m = len(costs)
        n = len(costs[0])
        prev = [0 for _ in range(n)]
        #dp = [[0  for _ in range(n)]for _ in range(m)]
        for j in range(n):
            prev[j] = costs[m-1][j]
        curr = [0 for _ in range(n)]
        for i in range(m-2,-1,-1):
            curr[0]=costs[i][0]+min(prev[1],prev[2])
            curr[1]=costs[i][1]+min(prev[0],prev[2])
            curr[2]=costs[i][2]+min(prev[0],prev[1])
            prev = curr
        return min(prev)

s= Solution()
print(s.minCost([[17,2,17],[16,16,5],[14,3,19]]))