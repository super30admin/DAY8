# Time: O(n)
# Space: O(n)
class Solution(object):
    def change(self, amount, coins):
        dp = [0 for i in range(amount + 1)]
        dp[0] = 1
        for i in range(1, len(coins) + 1):
            for j in range(amount + 1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j - coins[i-1]]
        print(dp)
        return dp[amount]
