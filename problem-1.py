# Time Complexity : O(n)
# space complexity : O(1)

# Approach :

# start with the n-2 th row, so that we can compare the last row and update the n-2th elements
# store the last row elements in variables
# start traversing from the second last row elements
# store the last row elements in a temp variable
# calculate the cost at each index by summing the current index cost and the minimum cost of the other colors.
# update the variables with the new cost and repeat the process till the first row is also complete
# finally return the min between the three colors .

class Solution:
    def minCost(self, arr: List[List[int]]) -> int:

        if not arr:
            return -1

        lenCosts = len(arr)

        lastRed = arr[lenCosts-1][0]
        lastBlue = arr[lenCosts-1][1]
        lastGreen = arr[lenCosts-1][2]

        for i in range(lenCosts-2, -1, -1):

            tempRed = lastRed
            tempGreen = lastGreen
            tempBlue = lastBlue
            lastRed = arr[i][0]+min(tempBlue, tempGreen)
            lastBlue = arr[i][1]+min(tempRed, tempGreen)
            lastGreen = arr[i][2]+min(tempRed, tempBlue)

        return min(lastRed, lastBlue, lastGreen)
