'''
Time complexity: O(n) where n is the number of houses
Space complexity: O(1) - as we are using constant space[3] R, B, G
Did this code successfully run on Leetcode :  Yes(#256)
Any problem you faced while coding this : No
Approach:
- Create a dp array of size 3 and initialize it with 0
- For each house, update dp[0], dp[1], dp[2] with the minimum cost of painting the house with R, B, G color respectively
'''


from typing import List

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        dp = [0]*(len(costs[0])) # 0-> R, 1-> B, 2-> G
        for i in range(len(costs)):
            dp[0], dp[1], dp[2] = costs[i][0] + min(dp[1],dp[2]) , costs[i][1] + min(dp[0],dp[2]), costs[i][2] + min(dp[0],dp[1])        
        return min(dp)
    


#Driver code
costs = [[17,2,17],[16,16,5],[14,3,19]]
sol = Solution()
print(sol.minCost(costs)) # 10