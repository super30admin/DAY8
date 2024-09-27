from typing import List


class Solution:

    def coin_change_dp_array(self, coins, amount):
        """
        The DP solution can be further optimized for space using 1D array.
         Time complexity: m*n space complexity O(m*n).
        Space complexity: m, amount
       :param coins: Array of coins
        :param amount: all possible combinations of given coins that makes the given amount
        :return: the number of combinations possible with given amount
        """
        cols = amount + 1
        rows = len(coins) + 1
        dp = [0 for _ in range(cols)]
        dp[0] = 1
        for col in range(1, cols):
            dp[col] = 0

        # print(dp)
        for i in range(1, rows):  # the amount is represented in rows and table filling start from 1 row
            for j in range(0, cols):  # coins
                if j < coins[i - 1]:  # since coins start from 1 index
                    dp[j] = dp[j]
                else:
                    dp[j] = dp[j] + dp[j - coins[i - 1]]  # n step back: coins[i]

        return dp[cols - 1]

    def coin_change_dp_matrix(self, coins, amount):
        """
        Greedy won't work in this case. Then use DP.
        Time complexity: m*n space complexity O(m*n).
        Space complexity: max height of the tree (m+n).
        :param coins: Array of coins
        :param amount: all possible combinations of given coins that makes the given amount
        :return: the number of combinations possible with given amount
        """
        # In the DP table since an extra row and col are added for amount 0 and number of coins 0,
        # add 1 to each number of rows and columns
        rows = len(coins) + 1  # sub problems for combinations of coins
        cols = amount + 1  # number of amounts possible till max amount
        dp = [[0 for _ in range(cols)] for i in range(rows)]
        # when number of coins = 0 and amount = 0, number of possible paths = 1
        dp[0][0] = 1
        # when number of coins = 0 and amount > 0, number of possible paths = 0
        for col in range(1, cols):
            dp[0][col] = 0

        # Since dp[0][j] is filled already update starts from the 1st row.
        for i in range(1, rows):
            for j in range(0, cols):  # need to fill all the columns so start with 0
                if j < coins[i - 1]:  # since coins start from 1 index (amount < denomination)
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]  # n step back: coins[i-1]

        return dp[rows - 1][cols - 1]  # index sarts with 0

    def coin_change_brute_force(self, coins, idx, amount):
        """
        This the brute force method which is trying all possible combinations of coins that makes the
        given amount.
        Time Complexity: O(2^(m+n)), since the number of nodes in recursion depends on the 2 parameters
        number of coins and amount.
        Space complexity: max height of the tree (m+n).
        :param coins: Array of coins
        :param idx: to keep track of what coin we want to choose or not choose
        :param amount: all possible combinations of given coins that makes the given amount
        :return: the number of combinations possible with given amount
        """
        # base case
        if idx >= len(coins) or amount < 0:
            return 0
        if amount == 0:
            return 1

        # logic for no choose
        no_choose = self.coin_change_brute_force(coins, idx + 1, amount)

        # logic for choose
        choose = self.coin_change_brute_force(coins, idx, amount - coins[idx])

        return no_choose + choose

    def change(self, amount: int, coins: List[int]) -> int:
        ans = self.coin_change_brute_force(coins, 0, amount)
        return ans
