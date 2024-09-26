# Time Complexity : O(amount*number of coins)
# Space Complexity : O(amount*number of coins)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for c in coins:
            for i in range(1, len(dp)):
                if c <= i:
                    dp[i] = dp[i] + dp[i - c]
        return dp[amount]

