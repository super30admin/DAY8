class Solution:
    def change(self, amount, coins):
        m = len(coins)
        n = amount
        # Edge case: If no coins are provided, there are 0 ways to make any amount
        if not coins or m == 0:
            return 0
        # Initialize the DP table
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        # Base case: 1 way to make amount 0 (use no coins)
        dp[0][0] = 1
        # Fill the first row: Cannot make any amount > 0 with 0 coins
        for j in range(1, n + 1):
            dp[0][j] = 0
        # Fill the remaining DP table
        for i in range(1, m + 1):
            for j in range(n + 1):
                if j < coins[i - 1]:  # Current coin value is greater than the amount
                    dp[i][j] = dp[i - 1][j]  # Don't choose the coin
                else:  # Consider both not choosing and choosing the coin
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[m][n]
