# The code defines a change method to calculate the number of ways to make up a target amount using a list of given coin denominations.
# This is a dynamic programming approach where each value in the dp array represents the number of ways to make up a specific amount.

# Initialization:
#   - The dp array is initialized with size (amount + 1) and filled with zeros.
#   - dp[0] is set to 1, as there is one way to make an amount of 0 (using no coins).

# Dynamic Programming Iteration:
#   - For each coin in the list of coins:
#       - For each amount 'i' from the coin's value up to the target amount:
#           - dp[i] is incremented by dp[i - coin], which represents the number of ways to make up amount 'i' by including the current coin.
#           - This ensures that each coin is considered for combinations that include itself and amounts achievable by previous coins.
# 
# Final Result:
#   - dp[-1] (the last element in dp) contains the number of ways to make up the target amount using the available coins, which is returned.

# TC: O(amount * n) - Where 'amount' is the target amount and 'n' is the number of coins, as each coin is considered for every sub-amount.
# SC: O(amount) - The space complexity is linear due to the dp array storing ways to make up each amount from 0 to the target.


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]

        return dp[-1]