class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = amount
        n = len(coins)

        matrix = [[0 for i in range(m+1)] for j in range(n+1)]

        for i in range(n+1):
            matrix[i][0] = 1

        for i in range(1, n+1):
            for j in range(m+1):
                if j < coins[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                else:
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i-1]]
        
        return matrix[n][m]

