class Solution:
    # Time Complexity O(M*N)
    
    
    
    def change(self, amount: int, coins: List[int]) -> int:
        if coins == None or len(coins) == 0:
            return 0
        m = len(coins)
        dp = [[0]*(amount+1)] * (m + 1)

        for i in range(1,m+1):
            dp[i][0] = 1

        for i in range(1,m+1):
            for j in range(1,amount+1):
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]

        return dp[m][amount]



        




        
    #     #Edge case

    #     if(len(coins) == 0 or coins == None):
    #         return 0

    #     return self.recursive(coins , amount , 0)

    # def recursive(self,coins : list[int], amount : int , index : int )  -> int:

    #     # Recursion limit

    #     if(amount < 0 or index >= len(coins)):
    #         return 0
        
    #     if(amount ==0 ):
    #         return 1
        

    #     case0 = self.recursive(coins, amount , index +1)
    #     case1 = self.recursive(coins , amount - coins[index] , index)

    #     return case0 + case1
