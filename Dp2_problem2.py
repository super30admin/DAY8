#518. Coin Change 2
#time complexity = O(nm) no of coins and amount value
#space complexity = O(nm)
# create a 2D array of amount as col and no of coins as rows.
# intialize column[0] = 0 and rest to infinity.
#check if amount in col is greater than coin denomination then copy the min value from above column
# check if (amount - value of current coin) can be made up from the i available denominations if yes add 1 to array[row][column-amount[row]]
#Ran on Leetcode: Yes

#with recursion
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(coins,amount,0)
    def helper(self,coins: List[int],amount: int, index :int ):
        #if coin is taken
        if amount == 0 :
            return 1
        if amount < 0 or index == len(coins):
            return 0
        
        case1:int = self.helper(coins,amount - coins[index], index)
        case2:int = self.helper(coins,amount, index + 1)
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1
        
        return case1 + case2

#with dp:
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp =[[0] * (amount + 1) for j in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 1
        for i in range(1,len(coins)+1):
            for j in range(1,amount +1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
                    
        return dp[-1][-1]