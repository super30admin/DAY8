'''
## Problem1 (https://leetcode.com/problems/paint-house/)

Example 1:
Input: costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19], [20, 2, 25]]
Output: 2 + 5 + 14 + 2 = 23

Solution1: Exhaustive Recursion
TC: O(2^n)
SC: O(n) due to recursive stack
Did this code successfully run on Leetcode : don't have a leetcode premium account
Any problem you faced while coding this : no

Solution2: Dynamic programming with a 2-D matrix
TC: O(n) filling up the 2-D matrix since number of columns is 3 which is constant
SC: O(n) for the 2-D matrix since number of columns is 3 which is constant
Did this code successfully run on Leetcode : don't have a leetcode premium account
Any problem you faced while coding this : no

Solution3: Dynamic programming without a 2-D matrix using 3 variables
TC: O(n) running the loop to compute the final values
SC: O(1) since only 3 variables and 2 temporary variables are used
Did this code successfully run on Leetcode : don't have a leetcode premium account
Any problem you faced while coding this : no
'''

class Solution1:
  def minCost(self, costs):
    if not costs or len(costs) == 0:
      return 0

    pickRed = self.minCostRecursive(costs, 0, 0)
    pickBlue = self.minCostRecursive(costs, 0, 1)
    pickGreen = self.minCostRecursive(costs, 0, 2)

    return min(pickRed, pickBlue, pickGreen)

  def minCostRecursive(self, costs, houseIdx, colorIdx):
    if houseIdx == len(costs):
      return 0

    if colorIdx == 0:
      return costs[houseIdx][colorIdx] + min(self.minCostRecursive(costs, houseIdx + 1, 1), self.minCostRecursive(costs, houseIdx + 1, 2))
    elif colorIdx == 1:
      return costs[houseIdx][colorIdx] + min(self.minCostRecursive(costs, houseIdx + 1, 0), self.minCostRecursive(costs, houseIdx + 1, 2))
    else:
      return costs[houseIdx][colorIdx] + min(self.minCostRecursive(costs, houseIdx + 1, 0), self.minCostRecursive(costs, houseIdx + 1, 1))

class Solution2:
  def minCost(self, costs):
    if not costs or len(costs) == 0:
      return 0

    n = len(costs)

    matrix = [[0 for x in range(3)].copy() for x in range(n)]

    #pre fill base case values
    for colorIdx in range(3):
      matrix[0][colorIdx] = costs[0][colorIdx]

    for houseIdx in range(1, n):
      matrix[houseIdx][0] = costs[houseIdx][0] + min(matrix[houseIdx - 1][1], matrix[houseIdx - 1][2])
      matrix[houseIdx][1] = costs[houseIdx][1] + min(matrix[houseIdx - 1][0], matrix[houseIdx - 1][2])
      matrix[houseIdx][2] = costs[houseIdx][2] + min(matrix[houseIdx - 1][0], matrix[houseIdx - 1][1])

    return min(matrix[n - 1])

class Solution3:
  def minCost(self, costs):
    if not costs or len(costs) == 0:
      return 0

    red = costs[0][0]
    blue = costs[0][1]
    green = costs[0][2]

    for houseIdx in range(1, len(costs)):
      tempRed = red
      tempBlue = blue
      red = costs[houseIdx][0] + min(blue, green)
      blue = costs[houseIdx][1] + min(tempRed, green)
      green = costs[houseIdx][2] + min(tempRed, tempBlue)

    return min(red, blue, green)

costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19], [20, 2, 25]]
print('Solution 1:')
s1 = Solution1()
print('The minimum cost required for painting houses with costs {} is {}.'.format(costs, s1.minCost(costs)))

print('Solution 2:')
s2 = Solution2()
print('The minimum cost required for painting houses with costs {} is {}.'.format(costs, s2.minCost(costs)))

print('Solution 3:')
s3 = Solution3()
print('The minimum cost required for painting houses with costs {} is {}.'.format(costs, s3.minCost(costs)))
