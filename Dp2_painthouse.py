# Time Complexity : O(n) n is the length of costs  array
# Space Complexity : O(n) dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here In this problem, I have created a new array i which I copied the first house color costs as the first row of new array.
# Then , I calculate the cost of each color by adding the cost of that particular house color and minumum of 
#previous house with other colors as we are not supposed to have same color of adjacent houses. At the end we will take 
#the minimum of the last house costs as it contains the cumulative cost of the houses.



class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        m = len(costs)
        dp = [[0]*3 for i in range(m)]

        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]

        for i in range(1,m):
            dp[i][0] = min(dp[i-1][1], dp[i-1][2])+costs[i][0]
            dp[i][1] = min(dp[i-1][0], dp[i-1][2])+costs[i][1]
            dp[i][2] = min(dp[i-1][0], dp[i-1][1])+costs[i][2]

        return min(dp[-1]) 