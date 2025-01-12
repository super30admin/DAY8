class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp_table = [[0 for _ in range(amount+1)] for _ in range(len(coins) + 1)]
        for i in range(len(coins)+1):
            dp_table[i][0] = 1
        for j in range(1, amount + 1):
            dp_table[0][j] = 0
        for i in range(1, len(coins) + 1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp_table[i][j] = dp_table[i-1][j]
                else:
                    dp_table[i][j] = dp_table[i-1][j] + dp_table[i][j-coins[i-1]]
        return dp_table[len(coins)][amount]

        