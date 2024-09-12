#LC 518 - Coin Change 2
#Recursive Solution
#Time Complexity - N^m where N is the number of coins and m is the amount
#Space Complexity - O(n) where n is the amount
#Could you please comment on both of the complexities?
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        def helper(coins,amount,index):
            #base case
            if amount == 0:
                return 1
            if amount < 0 or index >= len(coins):
                return  -1
            
            #logic
            #logic is to add both
            #Dont choose of the choices
            case1 = helper(coins,amount,index+1)
            #Choose
            case2= helper(coins,amount-coins[index],index)
            if case1 == -1:
                return case2 
            if case2 == -1:
                return case1
            return case1 + case2
        
        ans = helper(coins,amount,0)
        if ans == -1:
            return 0
        return ans


#LC 518 - Coin Change 2
#Dynamic Programming Solution
#Time Complexity - N*m where N is the number of coins and m is the amount
#Space Complexity - O(N*m) where N is the number of coins and m is the amount

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if amount == 0:
            return 1
        if not coins:
            return 0
        
        dp = []
        for i in range(len(coins)+1):
            dp.append([0]*(amount+1))
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        return dp[-1][-1]