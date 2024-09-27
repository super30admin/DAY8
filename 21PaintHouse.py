"""
// Time Complexity :O(mn) where m->cost and n->colours
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :NA

//Explanation:
Create dp matrix. Calculate dp[i][0]+= min(dp[i-1][1],dp[i-1][2]).
R 0->1,2
G 1->0,2
B 2->0,1 
Return min value from the last row.
"""
class Solution:
  def minCost(self,cost):
    if  cost is None or len(cost)==0:
      return 0
    n = len(cost)-1
    dp = [[0 for x in range(n+1)] for y in range(3)]
    dp[0][0] = cost[0][0]
    dp[0][1] = cost[0][1]
    dp[0][2] = cost[0][2]

    for i in range(1,len(dp)):
      dp[i][0] = cost[i][0] + min(dp[i-1][1],dp[i-1][2]) #Red
      dp[i][1] = cost[i][1] + min(dp[i-1][0],dp[i-1][2]) #Green
      dp[i][2] = cost[i][2] + min(dp[i-1][0],dp[i-1][1]) #Blue
    #print(dp,min(dp[n][0],dp[n][1],dp[n][2]))
    return min(dp[n][0],dp[n][1],dp[n][2])


if __name__=="__main__":
  cost=[[17,2,17],[16,16,5],[14,3,19]]
  s=Solution()
  print(s.minCost(cost))
