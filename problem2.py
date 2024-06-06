'''
## Problem1 (https://leetcode.com/problems/coin-change-2/)

Solution1: Exhaustive Recursion
TC: O(2^n)
SC: O(n) due to recursive stack
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : handling base cases

Solution2: Dynamic programming
TC: O(n^2) filling up 2-D matrix
SC: O(n^2) 2-D matrix 
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no

'''

#-----------------------Exhaustive Recursion-----------------------

class Solution1:
  def change(self, amount, coins):
    if coins == None or len(coins) == 0 or amount < 0:
      return -1

    return self.noOfWays(coins, amount, 0)

  def noOfWays(self, coins, amount, idx):
    #base cases
    if idx == len(coins) or amount < 0:
      return 0

    if amount == 0:
      return 1

    #recursion logic
    case0 = self.noOfWays(coins, amount, idx + 1)
    case1 = self.noOfWays(coins, amount - coins[idx], idx)

    return case0 + case1
  
#-----------------------Dynamic programming-----------------------

class Solution2:
  def change(self, amount, coins):
    if coins == None or len(coins) == 0 or amount < 0:
      return 0

    matrix = [[0 for i in range(amount + 1)].copy() for i in range(len(coins) + 1)]

    for row in range(1, len(coins) + 1):
      matrix[row][0] = 1

    for coinIdx in range(1, len(coins) + 1):
      for amtVal in range(1, amount + 1):
        if coins[coinIdx - 1] > amtVal:
          matrix[coinIdx][amtVal] = matrix[coinIdx - 1][amtVal]
        else:
          matrix[coinIdx][amtVal] = matrix[coinIdx - 1][amtVal] + matrix[coinIdx][amtVal - coins[coinIdx - 1]]

    return matrix[len(coins)][amount]

coins1 = [1, 2, 5]
amount1 = 5

coins2 = [1, 2, 3]
amount2 = 10

coins3 = [5, 10]
amount3 = 53

coins4 = [1, 2, 3, 5]
amount4 = 534

coins5 = [1, 2, 3, 5, 50, 100]
amount5 = 5344

coins6 = [5, 10]
amount6 = 53447


s1 = Solution1()
s2 = Solution2()
print('Using Exhaustive recursion:')
print()
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount1, coins1, s1.change(amount1, coins1)))
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount2, coins2, s1.change(amount2, coins2)))
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount3, coins3, s1.change(amount3, coins3)))
print()

print('Using Dynamic programming:')
print()
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount4, coins4, s2.change(amount4, coins4)))
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount5, coins5, s2.change(amount5, coins5)))
print('Number of ways in which {} can be formed using coin values {} is {}.'.format(amount6, coins6, s2.change(amount6, coins6)))
