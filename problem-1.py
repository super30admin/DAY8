# Time Complexity : O(n)
# space complexity : O(1)

# Approach :

# in this we add up the previous denominations value with the current denomination
# i is for traversing the rows (0 to len(coins)) and j ( 0 to amount) for the coulmns
# if coins[i] is greater than j we can add the value given by arr[i-1][j]
# else add the amount given by arr[i-1][j] and arr[i][j-coins[i]]

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
