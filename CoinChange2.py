# Explain your approach in three sentences only at top of your code
# Approach: Use dynamic programming to keep track of the number of ways to reach each amount from 0 to the target amount.
# For each coin, iterate through all possible amounts and update the ways to reach each amount by adding the ways to reach (current amount - coin).
# This avoids double counting combinations with the same set of coins in different orders.

# Time Complexity: O(amount * len(coins)), where amount is the target amount and len(coins) is the number of coin denominations.
# Space Complexity: O(amount), as we only use a 1D array to store the number of ways to reach each amount up to the target.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Initialize a dp array with amount+1 elements, all starting with 0 ways
        dp = [0] * (amount + 1)
        dp[0] = 1  # There's one way to make amount 0, by using no coins
        
        # Process each coin one by one
        for coin in coins:
            for i in range(coin, amount + 1):
                # Update the number of ways to make amount i by adding ways to make (i - coin)
                dp[i] += dp[i - coin]
        
        # The answer is the number of ways to make the target amount
        return dp[amount]
