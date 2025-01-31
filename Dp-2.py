## Problem1(https://leetcode.com/problems/paint-house/)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if costs == None or len(costs) == 0:
            return 0
        n = len(costs)
        dp = [[0 for i in range(3)] for j in range(n)]
        dp[n-1][0] = costs[n-1][0]
        dp[n-1][1] = costs[n-1][1]
        dp[n-1][2] = costs[n-1][2]

        for i in range(n-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][1], dp[i+1][0])
        
        return min(dp[0][0], dp[0][1], dp[0][2])
        
# explanation-
# The solution checks if the input costs is empty or None and returns 0 if true.
# A dynamic programming table dp is initialized to store the minimum painting costs for each house and color.
# The last house painting costs are set directly from the input costs.
# For each house from the second-last to the first, the solution calculates the minimum cost to paint it, considering the adjacent house constraints, and returns the minimum cost to paint all houses.
# Time complexity: O(n), where n is the number of houses
# Space complexity: O(n), where n is the number of houses.


## Problem2 (https://leetcode.com/problems/coin-change-2/)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0
        
        m = len(coins)
        dp = [[0] * (amount + 1)] * (m+1)
        for i in range(1, m+1):
            dp[i][0] = 1
        for i in range(1, m+1):
            for j in range(1, amount +1):
                if j < coins[i-1]:
                    dp[i][j] = dp [i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]]
        return dp[m][amount]
        
#Explanation-
# Base Case Check: The solution first checks if coins is empty or None. If true, it returns 0 as no combinations can be formed.
# DP Table Initialization: A 2D DP table dp is created where dp[i][j] represents the number of ways to make a total of j using the first i coins. The table is initialized to zeros.
# Filling the DP Table: For each coin and for each possible amount:
# If the current amount is less than the coin value, the number of ways remains the same as the previous row.
# Otherwise, the number of ways to form the amount is the sum of the number of ways without using the current coin (dp[i-1][j]) and the number of ways using the current coin (dp[i][j - coins[i-1]]).
# Return Result: Finally, the solution returns the value at dp[m][amount], which gives the total number of ways to form the amount using all the coins.
# Time and Space Complexity:
# Time Complexity: O(m * amount), where m is the number of coins and amount is the target value.
# Space Complexity: O(m * amount), where m is the number of coins and amount is the target value.






