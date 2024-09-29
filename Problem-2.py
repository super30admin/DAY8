'''
    Time Complexity: O(mn)
    Space Complexity: O(m)
    Approach: Similar to coin change just return the total ways instead of minimum number of coins
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        m = amount

        dp = [0 for j in range(m+1)]
        dp[0] = 1

        for j in range(1, m+1):
            dp[j] = 0

        for i in range(1, n+1):
            for j in range(m+1):
                if coins[i-1] > j:
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j - coins[i-1]]

        return dp[m]
        