// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Paint-House


def paint_house(costs):
    m = len(costs)
    n = len(costs[0])

    dp = [[0 for _ in range(n)] for _ in range(m)]

    for j in range(n):
        dp[m-1][j] = costs[m-1][j]

    for i in range(n-2,-1,-1): //Time-complexity = O(N)
        dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
        dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
        dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])
    return min(dp[0][0],dp[0][1],dp[0][2])
    





costs = [[17,2,17],[16,16,5],[14,3,19]]
print(paint_house(costs))

//Coin Change II
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [[0 for _ in range(amount+1)] for _  in range(len(coins)+1)]
        
        dp[0][0] = 1

        for j in range(1,amount+1):
            dp[0][j] = 0
        
        for i in range(1,len(coins)+1): //O(N^2)
            for j in range(0,amount+1):

                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]
