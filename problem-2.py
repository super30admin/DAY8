# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# space complexity : O(m*n), where m is the number of rows and n is the number of columns

# Approach :

# in this we add up the previous denominations value with the current denomination
# i is for traversing the rows (0 to len(coins)) and j ( 0 to amount) for the coulmns
# if coins[i] is greater than j we can add the value given by arr[i-1][j]
# else add the amount given by arr[i-1][j] and arr[i][j-coins[i]]


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:

        if not coins:
            return -1

        lenCoinArr = len(coins)
        noCol = amount
        arr = [[1] * (noCol+1)] * (lenCoinArr+1)

        repeatRange = range(1, noCol+1)

        for i in repeatRange:
            arr[0][i] = 0

        for i in range(1, lenCoinArr+1):
            for j in repeatRange:
                if coins[i-1] > j:
                    arr[i][j] = arr[i-1][j]
                else:
                    arr[i][j] = arr[i-1][j] + arr[i][j-coins[i-1]]

        return arr[lenCoinArr][noCol]
