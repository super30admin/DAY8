# Time Complexity is O(M*N) where M is number of coins and N is the amount
# Space complexity is O(N) where N is the amount
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1

        for c in coins:
            for a in range(1, amount + 1):
                if a >= c:
                    dp[a] = dp[a] + dp[a - c]

        return dp[amount]