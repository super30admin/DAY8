# // Time Complexity :O(n) for the traversal
# // Space Complexity :O(1) for variables and temps
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : for loop was i = m-2 to "-1" and not "0".


# // Your code here along with comments explaining your approach
# Since we know there are 3 paint colors we can just use them as variables.
# we can start from last row and iterate to the top row while storing current min paths using temp variables
# We can then find the least variable of the 3 as our answer. 
class Solution:
    def minCost(self, costs: list[list[int]]) -> int:
        m = len(costs)              # columns
        # n = len(costs[0])         # rows eliminated if using an array

        # dp = [[0]*(n+1) for i in range(m+1)]  # eliminate matrix for array
        #   array [R,B,G]                       # set last row as values
        colorR = costs[-1][0]
        colorB = costs[-1][1]
        colorG = costs[-1][2]

        for i in range(m-2,-1,-1):   # coming reverse from 2nd last row to 0th row[-1]
            tempR = colorR           # store current rows as temp
            tempB = colorB
            tempG = colorG
            colorR = costs[i][0] + min(tempB,tempG) #update new minimums
            colorB = costs[i][1] + min(tempR,tempG)
            colorG = costs[i][2] + min(tempR,tempB)

        return min(colorR,colorB,colorG) #find lowest value