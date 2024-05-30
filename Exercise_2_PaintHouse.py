# Time Complexity :

# O(N) , N = no. of houses


# Space Complexity :  

# O(N) , N = no. of houses, For Dynamic Programming (2D Matrix solution)


# Approach:
# We create a DP 2D array to store minimum cost of painting houses given the constraints.
# We use bottom-up approach sincem we can fix the costs in last row, and from each row aboce that
# we can start filling the costsfor that house using min(other colors).
# We finally return the minimum cost among the R, G and B values of the first house.


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs or len(costs)==0:
            return 0
        
        rows = len(costs)
        cols = len(costs[0])

        dp = [[0 for i in range(cols)] for j in range(rows)]
        print("Before dp", dp)

        for j in range(0,3):
            dp[rows-1][j] = costs[rows-1][j]

        for i in range(rows-2 ,-1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
        print("After dp", dp)
 
        return min(dp[0][0], min(dp[0][1], dp[0][2]))