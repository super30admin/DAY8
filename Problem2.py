#The provided function change calculates the number of ways to make a given amount using a set of coin denominations. It uses dynamic programming, where an array dp of size amount + 1 is initialized to store the number of ways to achieve each amount from 0 to the target amount. The function iterates through each coin, updating the dp array to reflect the additional ways to make each amount by including the current coin. This is achieved by adding the value of dp[i - coin] to dp[i] for each amount i from the coin's value up to the target amount. The time complexity of this approach is O(amount×len(coins)), and the space complexity is O(amount).

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1)
        dp[0] = 1
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] += dp[i - coin]

        return dp[-1]