# Time Complexity : O(m*n), where m in the amount and n is the number of types of coins in the array
# Space Complexity : O(m*n)
class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        if not coins:
            return 0
        
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)]# 2D Array that maintains the min number of coins (row) required to make the amount (column). Intialized to all zeroes.
        dp[0][0] = 1 # First cell is intialized to 1
        
        for i in range(1, len(coins) + 1):
            dp[i][0] = 1 # First Column is intialized to 1
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                     # Since one case is not possible here, the possible combinations for the current cell will be the same as the zero case
                    dp[i][j] = dp[i - 1][j]
                else:
                    #  Sets the current cell value as the sum of the zero case and one case for the current cell
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]
        
        return dp[len(coins)][amount] # Returns all the possible combinations

# Example 1
sol = Solution()
amount = 5
coins = [1, 2, 5]
print(sol.change(amount, coins))  # Expected output: 4

# Example 2
amount = 3
coins = [2]
print(sol.change(amount, coins))  # Expected output: 0

# Example 3
amount = 10
coins = [10]
print(sol.change(amount, coins))  # Expected output: 1

# Example 4
amount = 10
coins = [1, 2, 5]
print(sol.change(amount, coins))  # Expected output: 10

# Example 5
amount = 7
coins = [2, 3, 6]
print(sol.change(amount, coins))  # Expected output: 1

