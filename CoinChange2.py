#Space Complexity : O(N*M) where N is number of inputs and M is the amount  
#Time Complexity : O(N *M)  
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        dp = [[0 for x in range(amount+1)] for y in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0]=1
        for i in range (1,len(dp)):
            for j in range (1,len(dp[0])):
                if j < coins[i-1]  :
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        result = dp[len(dp)-1][len(dp[0])-1]
        
        return result