'''
Time complexity: O(n*m) where n is the amount and m is the number of coins
Space complexity: O(n) where n is the amount
Did this code successfully run on Leetcode : Yes (#518)
Any problem you faced while coding this : No
Approach:
- Create a dp array of size amount+1 and initialize it with 0
- dp[0] = 1 as there is only 1 way to make amount 0 i.e. by not selecting any coin
- Iterate over coins and for each coin, iterate over amount from coin to amount+1 - as we can make amount using coin only if amount >= coin
- For each amount, update dp[amount] = dp[amount] + dp[amount-coin]
'''


from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount + 1)
        dp[0] = 1
        for i in range(len(coins)):
            for j in range(coins[i],amount+1):
                    dp[j] += dp[j-coins[i]]
        
        return dp[amount]
    
    
#Driver code
amount = 5
coins = [1,2,5]
sol = Solution()
print(sol.change(amount, coins)) # 4