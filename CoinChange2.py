# Time Complexity : O(m * n), where m is the number of coins and n is the amount
# Space Complexity : O(m * n), where m is the number of coins and n is the amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# to store the values of repeated subproblems, we use dp, 2d array because 2 decision making params - coins and amount
# every cell is the storing the total number of ways to make that amount, rows are coins and columns are the amounts
# every coin can have 2 cases - whether to pick the coin or not
# the 0 case is the case when the coin is not picked, then the amount remains same, and this value is found in the column, previous row
# the 1 case is when the coin is picked and the amount changes, and the value is found at amount - current_coin_value columns behind the current column
# every cell stores the sum of these two cases
# the last cell will contain the final value of max number of ways to make the final amount



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """

        if coins is None:
            return -1
        
        # initializing the 2D array
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)]

        # first column as 1, because 1 way to make amount 0 with any number of coins, i.e 0
        for i in range(len(coins) + 1):
            dp[i][0] = 1
        
        # first row will be set to 0, because there are 0 ways to make any amount using 0 coins
        for j in range(1, amount + 1):
            dp[0][j] = 0
        
        # tarversing the two d array
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                # if amount is less than the current value of coin, then we consider 0 case only
                # because 1 case will lead to negative amount
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    # amount is equal or greater than the current coin
                    # we will consider both 0 and 1 case

                    # case0 is not picking the coin, value lies in the above row
                    # j is same because amount will not change if we are not picking that coin
                    case0 = dp[i-1][j]

                    # case 1 is picking the coin
                    case1 = dp[i][j - coins[i-1]]

                    # total possible ways to make the amount is the sum of both cases
                    dp[i][j] = case0 + case1

        # return the last cell in the array       
        return dp[len(coins)][amount]

        