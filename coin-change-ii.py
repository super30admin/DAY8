# The algorithm uses dynamic programming to count the number of ways to make up the given amount by iterating through each coin 
# and updating the possible combinations for each sub-amount. It returns the total number of ways to make the amount using 
# the given coins.

# Time: O(N * M) (N = amount, M = number of coins) | Space: O(N).
# class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        min_coins = [0] * (amount + 1)
        min_coins[0] = 1
        for c in coins:
            for i in range(c, amount + 1):
                min_coins[i] = min_coins[i] + min_coins[i - c]
        return min_coins[amount]
