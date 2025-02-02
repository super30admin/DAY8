# Brut Force Recursive
# Time complexity: O(2 ^ n*m)
# Space : O(m*n) not sure
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.getWays(amount, coins, 0)
        
    def getWays(self, amount: int, coins: List[int], index):
        if amount == 0:
            return 1
        if amount <= 0 or index >= len(coins):
            return 0
        # choose #not choose
        return self.getWays(amount - coins[index], coins, index) + self.getWays(amount, coins, index+1)
        

# Brut for with memoization
# Time: O(n)
# Space: O(n*m)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memoArr = [[-1] * (amount+1) for i in range(len(coins))]
        return self.getWays(amount, coins, 0, memoArr)

    def getWays(self, amount: int, coins: List[int], index, memoArr:[[int]]):
        if amount == 0:
            return 1
        if amount <= 0 or index >= len(coins):
            return 0
        if memoArr[index][amount] != -1:
            return memoArr[index][amount]
        # choose #not choose
        
        ways = self.getWays(amount - coins[index], coins, index, memoArr) + self.getWays(amount, coins, index+1, memoArr)
        memoArr[index][amount] = ways
        return ways

# Time: O(n*m)
# Space: O(n*m)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[0] * (amount+1) for i in range(len(coins)+1)]
        for j in range(1, len(coins)+1):
            dp[j][0] = 1
            for i in range(1, amount+1):
                dp[j][i] = dp[j-1][i] +  dp[j][i-coins[j-1]] if i-coins[j-1] >= 0 else dp[j-1][i]
        return dp[-1][-1]
        
#Time: O(n*m)
# SPace: O(m) , m = amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount+1)
        dp[0] = 1
        for j in range(0, len(coins)):
            for i in range(1, amount+1):
                dp[i] = dp[i] + dp[i-coins[j]] if i-coins[j] >= 0 else dp[i]
        return dp[-1]
        
               
        