#Time Complexity=O(amount*n),
#SC-O(amount)
#Ran successfully in Leetcode:Yes
#Same procedure as followed for previous COin chane problem . Here we do not calculate the min(dp[i],dp[i-coin], here we just increment the dp[amount]by dp[amount-coin]).And return the value stored at dp[amount]

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        dp = [0]*(amount+1)
        dp[0] = 1
        for coin in coins:
            for i in range( 1,amount+1):
                if i>=coin:
                     dp[i] += dp[i-coin]
                    # dp[i]=dp[i]
            # print(dp)
        return dp[-1] 
    
