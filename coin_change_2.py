# TIme complexity = O(m*n)
# Space complexity = O(n*n)
# tested on leetcode
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        m = len(coins)
        n = amount
        dp = [[0]*(n+1) for i in range(m+1)]
        dp[0][0] = 1 # one way to form 0from 0 is 1
        for i in range (m+1):
            for j in range(n+1):
                if j > coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i- 1]]
        return dp[m][n]

    #Recursive solution
    # TIme complexity = O(2^n) n -> no of houses
    # Space complexity = O(n)
    # tested on leetcode
    def  helper(coins, index, amount):
        if amount < 0 or index == len(coins)-1:
            return 0
        if amount == 0:
            return 1

        # not choose
        case1 =  helper(coins, index+1, amount)
        case2 =  helper(coins, index, amount - coins[index])
        return case1 + case2

    val =  helper(coins, 0, amount) 

    return val 


