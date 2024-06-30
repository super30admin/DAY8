#time = O(n×amount)
#space = O(amount)
def change(amount, coins):
    # dp[i] will be storing the number of ways to make up amount i
    dp = [0] * (amount + 1)
    dp[0] = 1  # There is one way to make amount 0, which is not to use any coins.
    
    # Iterate over each coin
    for coin in coins:
        # Update the dp array for all amounts from coin to amount
        for x in range(coin, amount + 1):
            dp[x] += dp[x - coin]
    
    return dp[amount]

# Example usage
amount = 5
coins = [1, 2, 5]

print(change(amount, coins))  # Output: 4