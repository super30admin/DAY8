"""
518. Coin Change II

TC - O(m * n)
SC - O(m * n)
"""

c = [1, 2, 5]
amt = 5


def coinChange(coins, amount):
    if coins is None or len(coins) == 0: return -1

    n = len(coins)

    dp = [0] * (amount + 1)

    # make 0th col to be 0
    dp[0] = 1

    for i in range(n - 1, -1, -1):
        for j in range(coins[i], amount + 1):
            dp[j] += dp[j - coins[i]]

    return dp[amount]


def coinChange2DMatrix(coins, amount):
    if coins is None or len(coins) == 0: return -1

    m = len(coins)
    n = amount

    dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

    # fill 0th col with 1 since there's 1 way to form 0 amount
    for i in range(m + 1):
        dp[i][0] = 1

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if j < coins[i - 1]:
                # take value from the cell above
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

    return dp[m][n]


if __name__ == '__main__':
    print(coinChange2DMatrix(c, amt))
    print(coinChange(c, amt))
