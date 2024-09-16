'''
So1 1:
Time Complexity :O(S*n) A is the amount and n is the number of coins
Space Complexity: O(1)
Did this code successfully run on Leetcode : No (Max Recursive depth on large denomination and few edge cases to fix)
Explanation: Create a function and traverse recursively every time we decrease the amount by a denomination and find
all subproblems, count the number of correct subproblems on the way.

Sol 2:
Time Complexity :O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a function similar to Coin change 1 but instead of counting the max just fnd the count of subproblems.
'''

class Solution:

    def change(self, amount: int, coins: List[int]) -> int:
        return self.Change(coins, amount, 0)

    def Change(self, coins: List[int], amount: int, count: int) -> int:

        if amount == 0:
            return 1

        if amount < 0 or count >= len(coins) - 1:
            return 0

        case2 = self.Change(coins, amount, count)
        case1 = self.Change(coins, amount - coins[i], count + 1)

        return case1 + case2

    def DPchange(self, amount: int, coins: List[int]) -> int:
        if coins == None:
            return 0

        m = len(coins)
        n = amount

        dp = [[0] * (amount + 1) for i in range(0, len(coins) + 1)]

        for i in range(0, len(dp)):
            dp[i][0] = 1

        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]

        return dp[m][n]