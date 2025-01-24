# 256. Paint House_Solution_Q1

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs== None or len(costs)==0:
            return 0
        n= len(costs)
        dp=[[0 for i in range(3)] for j in range(n)]
        dp[n-1][0]= costs[n-1][0]
        dp[n-1][1]= costs[n-1][1]
        dp[n-1][2]= costs[n-1][2]

        for i in range(n-2, -1, -1):
            dp[i][0]= costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1]= costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2]= costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        
        return min(dp[0][0], dp[0][1], dp[0][2])

# TC: O(n) no of houses O(m*n)> O(m*3)>O(n) 3=constant
# SC: O(n)

-----------------------------------------------------------------------------------------------------------------------------------

# 518. Coin Change II_Solution_Q2

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins)==0:
            return 0
        
        m= len(coins)
        dp= [[0]* (amount+1)] * (m+1)
        for i in range(1, m+1):
            dp[i][0]=1
        for i in range(1, m+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= dp[i-1][j]+ dp[i][j-coins[i-1]]
        return dp[m][amount]

# TC: O(m*n)
# SC: O(m*n)