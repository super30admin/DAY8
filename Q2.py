######### Coin Change 2


# Time Complexity : O(n*m) where n is the target amount and m is the number of coins
# Space Complexity : O(n*m) where n is the target amount and m is the number of coins
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#   go through the array and keep filling it such that if the amount-current_coin_value is valid then we add the amount - current_coin and the previous coins value.


def coin_change(coins,target):
    if not coins:
            return -1
            
    dp = [[0] * (target + 1) for _ in range(len(coins) + 1)]
    dp[0][0] = 1
        
    for i in range(1,len(dp)):
        for j in range(len(dp[0])):
            dp[i][j] += dp[i - 1][j]
            if j - coins[i-1] >=0:
                dp[i][j] +=dp[i][j-coins[i-1]]
                    
    return dp[-1][-1]

# Time Complexity : O(n) where n is the target amount
# Space Complexity : O(n) where n is the target amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# optimise by using a one-d array and overwriting as we only need one previous row

def coin_change_2(coins,target):
    if not coins:
            return -1
        
    dp = [0] * (target + 1) 
    dp[0]= 1
        
    for j in range(len(coins)):
        for i in range(len(dp)):
            dp[i] = dp[i]
            if i - coins[j] >= 0:
                dp[i] += dp[i-coins[j]]
                    
    return dp[-1]
