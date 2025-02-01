# Time Complexity : O(m*n) - m is amount, n is len(coins)
# Space Complexity : O(m*n) - m is amount, n is len(coins)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Build a matrix to store the number of combinations for all permutations and combinations of amount and coins.
But as there will be repeated sub problems, calculate only once for every repeated sub problems.

"""

def change(amount, coins):
    #     m = len(coins)
    #     n = amount
    #     result = self.helper(coins, 0, amount)
    #     return result

    # def helper(self, coins, i, amount):
    #     if (amount == 0):return 1
    #     if (i == len(coins) or amount < 0):
    #         return 0
    #     return self.helper(coins, i+1, amount) + self.helper(coins, i,amount - coins[i])

    """
    :type coins: List[int]
    :type amount: int
    :rtype: int
    """

    m = len(coins)
    n = amount
    dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

    # fill dp[0][0] to 1 as there is only one way to make amount 0 with coin with 0 denomination
    dp[0][0] = 1

    # fill the dp matrix
    for i in range(1, m + 1):
        for j in range(0, n + 1):
            # if amount is less than coin denomination, we cannot use that coin ,
            # so take the value as without using the coin
            if j < coins[i - 1]:
                dp[i][j] = dp[i - 1][j]
            else:
                # not choosing that coin + choosing that coin
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

    return dp[m][n]