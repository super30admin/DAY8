# Time = O(n^2)
# Space = O(n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins:
            return 0 
        dp = [0 for _ in range(amount+1)]
        dp[0] = 1
        for coin in coins:
            for j in range(coin, amount+1):
                dp[j] += dp[j-coin]
        return dp[amount]