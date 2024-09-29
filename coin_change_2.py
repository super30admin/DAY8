class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m = len(coins)
        n = amount

        dp = [[0] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = 1

        for i in range(1, m + 1):
            for j in range(0, n + 1):
                if j < coins[i - 1]:  # no choose case
                    dp[i][j] = dp[i - 1][j]
                else:  # choose case
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        return dp[m][n]


# Time complexity:O(n*m)
# space complexity : 0(n*m)
