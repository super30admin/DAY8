"""

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10]
Output: 1

Time Complexity: O(m×amount) for both methods, since we iterate through each coin and each amount up to amount
Space Complexity: O(m×amount) for the 2D DP solution and O(amount) for the optimized 1D DP solution.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# This solution uses dynamic programming to count the number of ways to make change for a given amount using the given coins. 
# The first approach uses a 2D DP table (dp[i][j]) where each entry represents the number of ways to make 'j' amount using the first 'i' coins, 
# while the second approach optimizes space by using a 1D DP array where dp[j] accumulates ways to make 'j' using the given coins iteratively.


class Solution:

    def change(self, amount: int, coins: List[int]) -> int:

        if coins is None or len(coins) == 0:
            return 0

        # Method 1: Time Complexity - O(m * amount), Space Complexity - O(m * amount)
        m = len(coins)
        
        dp = [[0] * (amount + 1) for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = 1

        for i in range(1, m + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][amount]   

        # Method 2: Time Complexity - O(m * amount), Space Complexity - O(amount)
      
        dp = [0] * (amount + 1)
        dp[0] = 1

        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] += dp[j - coin]

        return dp[amount]
