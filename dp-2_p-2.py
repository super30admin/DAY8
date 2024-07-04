class Solution:
    def change(self, amount: int, coins) -> int:

        # dp needs to be initialised with how many ways a certain amount can
        #be formed from a certain denomination of coins eg: 1c 6a implies 
        #only 1 way (6*1)

        #the decision tree for exhaustive showed that amount =0 finally 
        # means soln has arrived 

        dp=[0]*(amount+1) 
        dp[0]=1 #with 0 coin, 0 amount implies 1 way
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i]= dp[i]+ dp[i-coin]
        return dp[amount]    