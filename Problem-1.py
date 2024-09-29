'''
    Time Complexity: O(mn)
    Space Complexity: O(1)
    Approach: Use Dynamic Programming. 
    Every house color set alternate colors for adjacent. 
    Store previous values before optimizing. 
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        m = len(costs[0])

        dp = costs[n-1]

        for i in range(n-2, -1, -1):
            temp = [dp[0], dp[1], dp[2]]

            for j in range(m):
                if j == 0:
                    dp[j] = costs[i][j] + min(temp[1], temp[2])
                elif j == 1:
                    dp[j] = costs[i][j] + min(temp[0], temp[2])
                else:
                    dp[j] = costs[i][j] + min(temp[0], temp[1])

        return min(dp)