# Time complexity: O(N * M) (M = number of colors)
# Space complexity: O(N * M)
#Compiled on leetcode: Yes

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        rows = len(costs)
        if rows == 0:
            return 0
        columns = 3
        dp = [[0 for i in range(columns)] for j in range(rows)]
        dp[0] = costs[0]
        for i in range(1, rows):
            for j in range(columns):
                if j == 0:
                    dp[i][j] = costs[i][j] + min(dp[i - 1][j + 1], dp[i - 1][j + 2])
                elif j == 1:
                    dp[i][j] = costs[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j + 1])
                else:
                    dp[i][j] = costs[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j - 2])
        return min(dp[-1])            

