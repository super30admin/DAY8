# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# We will imagine a mxn matrix where where row is the coins and columns is the amount.
# we can then set base conditions for first row since 0 goes in 0 once but 0 does nto go in any other amount.
# we get invalid conditions from the above row.
# then from 2nd rowe find sub problems for row and columns. We want to add the combinations. Last term of dp is the Solution.


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        m = len(coins)                              # col
        n = amount                                  # row

        dp = [[0] * (n+1) for col in range(m+1)]    # dp matrix
        
        #base conditions
        dp[0][0] = 1                                # [0][0] is 1 

        for i in range(1,m-1):                      # Entire row is 0
            dp[0][i] = 0

        #logic
        for i in range(1,m+1):
            for j in range(0,n+1):
                if j < coins[i-1]:                  # invalid condition
                    dp[i][j] = dp[i-1][j]
                else:                               # choose + no choose 
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]]

        return dp[m][n]
        