# if the choose case is smaller than the column value than consider the no choose case value else compare both choose and no choose case value and add them as we want all the possible path
# T.C = O(m * n) S.C = O(m * n)
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m = len(coins)
        n = amount
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]

        dp[0][0] = 1

        for i in range(1,m+1):
            for j in range(0,n+1):
                if(j<coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        print(dp)

        return dp[m][n]
            