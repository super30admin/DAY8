class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        

        # def helper(coins,idx,amount):

        #     if amount<0:
        #         return 0
        #     if idx>=len(coins):
        #         return 0
        #     if amount==0:
        #         return 1

        #     return helper(coins,idx+1,amount) + helper(coins,idx,amount-coins[idx])

        # return helper(coins,0,amount)

        dp_array = [0]*(amount+1)
        dp_array[0]=1

        for coin in coins:
            for i in range(1,amount+1):
                if i>=coin:
                    dp_array[i]+=dp_array[i-coin]

        return dp_array[-1]    

