#Time complexity: O(a*n) where a is the amount and n is the number of coins
#Space complexity: O(a) where a is the amount
#Works on leetcode: yes
#Approach:Here dp is an array to store the number of combinations given the coin we need to make up a certain amount of money, 
#the index of dp means the amount of money to make up, so dp[x] means to make up money amount x 
# how many combinations we need. For each amount and each coin, the resulting combination is added to the current by 
#removing the current coin from current amount. 
class Solution:
	#Function to get the combinations of coins to get the given amount
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount+1)
        dp[0] = 1
        for c in coins:
            for j in range(c,amount+1):
                dp[j] += dp[j-c]
        return dp[amount]
    #Second function to get the combinations of coins to get the given amount
    def change2(self, amount: int, coins: List[int]) -> int:
        return self.combination(amount, 0, coins, 1)
    #helper recursive function for base solution
    # Time = O(2^(n/min(coins)))
    # Space = O(n) for recursive stack
    def combination(self, amount, ind, coins, counts):
        if amount<0 or ind>=len(coins):
            return 0
        if amount==0:
            return 1
        count = self.combination(amount, ind+1, coins, counts) + self.combination(amount - coins[ind], ind, coins, counts)
        return count