'''
Time Complexity :
O(n*m)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

dp = [0] * (amount + 1)
dp[0] = 1

for coin in coins:
    for i in range(coin, amount + 1):
        dp[i] += dp[i - coin]

return dp[amount]