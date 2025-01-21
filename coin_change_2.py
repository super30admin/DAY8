def coin_change_2(amount, coins):
    dp = [0] * (amount + 1)
    dp[0] = 1  

    for coin in coins:
        for x in range(coin, amount + 1):
            dp[x] += dp[x - coin]

    return dp[amount]

# Time Complexity: O(n * m) where n is the amount and m is the number of coins.
# Space Complexity: O(n) where n is the amount (1D array is used).
