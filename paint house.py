# TC: O(m*n)
# SC: O(m*n)
# This is an LC premium question. Could not compile.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = costs
        for i in range(len(dp) - 2, -1, -1):
            for j in range(len(dp[0])):
                if j == 0:
                    dp[i][j] += min(dp[i + 1][j + 1], dp[i + 1][j + 2])
                elif j == 1:
                    dp[i][j] += min(dp[i + 1][j - 1], dp[i + 1][j + 1])
                else:
                    dp[i][j] += min(dp[i + 1][j - 2], dp[i + 1][j - 1])

        return min(dp[0][0], dp[0][1], dp[0][2])  
                           
                           
