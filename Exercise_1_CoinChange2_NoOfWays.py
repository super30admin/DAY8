# Time Complexity :

# O(M*N) , M = no. of coins, N = amount


# Space Complexity :  

# O(M*N) , M = no. of coins, N = amount , For Dynamic Programming (2D Matrix solution)


# Approach:


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        # Dynamic programming Solution
        if not coins or len(coins) == 0 :
            return 0
        
        # create a 2D DP array
        rows = len(coins)+1
        cols = amount+1

        dp = [[1]*cols]*rows  # initialize with 1, since for first column, we have only 1 way to get amount 0, i.e "not picking up the coin"
        
        # First row , fill with 0 (there is "no way" to create those sums using coin value = 0)
        for j in range(1, cols):
            dp[0][j] = 0
        
        # then fill the rest of DP array
        for i in range(1, rows):
            for j in range(1, cols):
                # check if current amount(j) is less than coin value(i)
                if j < coins[i-1]: 
                    dp[i][j] = dp[i-1][j]  # access the coin value at "i-1" index since we added an extra dimension for row
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

        return dp[rows-1][cols-1]