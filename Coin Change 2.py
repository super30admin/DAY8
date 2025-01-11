#Time complexity:O(mn)
#Space complexity: O(mn)
#Leetcode: Yes

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp_matrix = [[0] * (amount+1) for _ in range(len(coins)+1)]

        for i in range(len(coins)+1):
            dp_matrix[i][0] = 1

        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i-1]:
                    dp_matrix[i][j] = dp_matrix[i-1][j]
                else:
                    dp_matrix[i][j] = dp_matrix[i-1][j]+dp_matrix[i][j-coins[i-1]]

        return dp_matrix[-1][-1]