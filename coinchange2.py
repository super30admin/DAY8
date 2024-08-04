class Solution:
    # time: O(n2)
    # space: O(n2)
    def change(self, amount: int, coins: List[int]) -> int:

        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]

        for i in range(len(dp)):
            dp[i][0] = 1

         # i = amount, j= coins    
        for coin in range(1,len(dp)):
            for amt in range(1, len(dp[0])):
                if amt < coins[coin-1]:
                    dp[coin][amt] = dp[coin-1][amt]

                else:
                    dp[coin][amt] = dp[coin-1][amt] + dp[coin][amt - coins[coin-1]]

        return dp[-1][-1]