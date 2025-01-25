# Time Complexity : O(coins*amount)
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


dp = [0] * (amount + 1)
dp[0] = 1

for coinsidx in range(1, len(coins)+1):
    for amt in range(amount+1):
        if amt >= coins[coinsidx-1]:
            dp[amt] += dp[amt-coins[coinsidx-1]]

return dp[-1]