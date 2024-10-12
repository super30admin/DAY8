# Approach 1 (Recursive)
# time complexity: O(3*2^n)
# space complexity: O(n)

# class Solution:
#     def minCost(self, costs: List[List[int]]) -> int:
#         costR = self.helper(costs, 0, 0, 0)
#         costB = self.helper(costs, 0, 1, 0)
#         costG = self.helper(costs, 0, 2, 0)

#         return min(costR, min(costB, costG))

#     def helper(self, costs: List[List[int]], i: int, color: int, totalCost: int) -> int:

#         # base case
#         # if i goes out of bound
#         if i>=len(costs):
#             return totalCost

#         # logic
#         if color==0:
#             return min(
#             self.helper(costs, i+1, 1, totalCost+costs[i][0]),
#             self.helper(costs, i+1, 2, totalCost+costs[i][0])
#             )
#         elif color==1:
#             return min(
#             self.helper(costs, i+1, 0, totalCost+costs[i][1]),
#             self.helper(costs, i+1, 2, totalCost+costs[i][1])
#             )
#         elif color==2:
#             return min(
#             self.helper(costs, i+1, 0, totalCost+costs[i][2]),
#             self.helper(costs, i+1, 1, totalCost+costs[i][2])
#             )
#         return -1

# ----------------------------------------------------------------------------------------------

# Approach 2 (DP Matrix)
# time complexity: O(m*n)
# space complexity: O(m*n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])

        import numpy as np
        dp = np.zeros((m, n), dtype=int)

        # clone costs matrix last row to dp matrix last row
        for j in range(0, n):
            dp[m-1][j] = costs[m-1][j]

        # construct other rows based on last row in dp matrix
        for i in range(m-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        
        return min(dp[0][0], min(dp[0][1], dp[0][2]))








