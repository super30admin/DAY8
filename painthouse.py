#time complexity: o(n) 
#space complexity: o(n)
#passed all cases on LeetCode: yes
#difficulty faced:none
# comments:in the code
#https://leetcode.com/problems/coin-change-2/

class Solution:
    """
    @param costs: n x 3 cost matrix
    @return: An integer, the minimum cost to paint all houses
    """
    def min_cost(self, costs: 'List[List[int]]') -> int:

        #cols is 3 bec there are just 3 colors
        rows, cols = len(costs), 3
        dp = [[0 for j in  range(cols)] for i in range(rows)]

        #copying the last row as is in dp array 
        
        for j in range(0,cols):
            dp[rows-1][j] = costs[rows-1][j]

        #we will start adding from sec last row, have to choose other 2 colors apart from yours
        #this way when we reach top row we would have aggregated all the required array numbers
        for i in range(rows-2,-1,-1):
                dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2]) 
                dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
                dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])

        min1 = float('inf')
        for j in range(0,cols):
            min1 = min(min1,dp[0][j])
        return min1


s1 = Solution()

ar = [[14,2,11],[11,14,5],[14,3,10]]

print(s1.min_cost(ar))