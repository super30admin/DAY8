# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount

        dp = [[0 for _ in range(n+1)] for _ in range(m+1)] 
        dp [0][0] = 1

        for i in range(1, m + 1):
            for j in range(n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]
        