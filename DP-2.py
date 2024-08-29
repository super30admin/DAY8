## Problem1(https://leetcode.com/problems/paint-house/)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        n = len(costs)
        costR = cost[n-1][0]
        costB = cost[n-1][1]
        costG = cost[n-1][2]
        for i in  range(n-2,-1,-1):
            tempR = costR
            costR = costs[i][0] + min(costB, CostG)
            tempB = costB
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)
        return min(costR, costB, costG)
#TC = O(n), SC = O(1)             

## Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0
        m = len(coins)
        dp = [[0] * (amount+1)] * (m+1)
        for i in range(m+1):
            dp[i][0] = 1
        for i in range(1, m+1):
            for j in range(1,(amount+1)):
                if j < coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[m][amount]
# TC = O(m*n), SC = O(m*n)