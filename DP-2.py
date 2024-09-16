
#Problem 1: Paint House
#Time Complexity: O(n) (only 3 rows whatever n)
#Space Complexity: O(1) (use the cost matrix directly)
#Did this code successfully run on leetcode: yes

'''
brute force:
Try all the colors, with a condition that it cannot be like the previous one, and take the branch with minimum value.
'''
'''
idea:
DP matrix, columns are the colors, rows are the houses. We can for each row, check what is the minimal price we have to pay if we want to paint this
house this color. So minimum price to pay if we want to paint it green, it's the cost of green+ the minimum of the minimum price to paint the previous house red or blue (cannot be green). Then we check for red, and blue for this row. The minimum of the final row is what we seek.We can actually change the cost matrix direclty. First row doesn't have any restrictions for the colors, so minimum to paint it that color is just price of that color. Practice noticing the patterns!

'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #edge case
        if not costs:
            return 0
        #we start the loop from 1 since first row is already the values we want
        for i in range(1,len(costs)):
            #don't forget to add the cost of the house itself
            costs[i][0]+=min(costs[i-1][1],costs[i-1][2])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][1],costs[i-1][0])
        return min(costs[-1][0],costs[-1][1],costs[-1][2])

#Problem 2: Coin Change 2
'''
Brute force:
Top down, we start from the amount and substract coins until we are smaller or equal to zero. If zero, we count the
add to the count of valid. O(coins^amount)
'''
#Time Complexity: O(n*a), number of coins times amount
#Space Complexity: O(n*a)
#Did this code successfully run on leetcode: yes\
'''
We notice here that we might reach the same amount a given row in the tree. meaning that the branches after that will be the same.
So instead of calculating these we can just multiply the number of valid branches times the number of same branches. In practice we won't use a multiplication.
Main idea: We create a dp matrix.  Columns are amounts from 0, rows are coins. For a given row and column , we get the value by adding the value
from the top (how many ways we can get this without using this new coin) and the value from the same row at index (i-coin). So we can either get this amount by not using the new coin at all, or all the ways we got to amount-coin (we add +coin to them to reach desired amount). If there are no ways
we put it stays at 0, so no need to check.
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if not coins and not amount:
            #depends, philosophical. how many ways can you make 0 with no coins
            return 1
        if not coins:
            return 0
        dp=[[0]*(amount+1) for i in range(len(coins)+1)]

        # how can you make 0 with all the coins? one way for each.
        #this is important since 0+coin is one valid way to reach it
        for i in range(len(dp)):
            dp[i][0]=1
        for i in range(1,len(dp)):
            for j in range(1,len(dp[0])):
                dp[i][j]+=dp[i-1][j]
                if j>=coins[i-1]:
                    #i-1 because we added a coin 0
                    dp[i][j]+=dp[i][j-coins[i-1]]
        return dp[-1][-1]
