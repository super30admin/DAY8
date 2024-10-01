# Approach 1 : Recursive
# Every time we will choose or not choose the element if we choose same index will be passed to next
#recursive call else pass the next index to next recursive call.
# if amount is zero then give 1 else if amount is not zero and last index is called return 0

# complexities
#Time Complexity : 2^(m+n)
#Space Complexity : o(1) + O(recursive auxillaryspace)

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(amount,coins,0)

    def helper(self,amount,coins,index):

        if amount==0:
            return 1
        elif (index == len(coins)):
            return 0

        case0 = self.helper(amount,coins,index+1)
        case1  =0
        if amount-coins[index]>=0:
            case1 = self.helper(amount-coins[index],coins,index)

        return case0+case1


# Approach 2 : Bottom-up(tabulation)
# We saw some sub problems in the recursive is repeating so there are 2 variables amount and denomination
# So create a 2-D array to reuse the already computed values
# in this convert recursive function for choose not choose contions and fill the dp array

# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(m*n)

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)

        dp = [[0] * (amount + 1)] * (n + 1)
        print(dp)
        for i in range(len(dp)):
            dp[i][0] = 1

        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                case0 = dp[i - 1][j]
                case1 = 0
                if j - coins[i - 1] >= 0:
                    case1 = dp[i][j - coins[i - 1]]+1
                dp[i][j] = case0 + case1

        return dp[n][amount]


# Approach 3: Bottom-up(tabulation)(Space Optimaization)
# Since we are only depending on the previous row to compute the present row value we can eleminate remaining rows using 2-!D arrays

# complexities
#Time Complexity : O(m*n)
#Space Complexity : O(m)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        prev = [0] * (amount+1)
        prev[0] = 1

        for i in range(1, n + 1):
            curr = [0] * (amount + 1)
            for j in range(1, amount + 1):
                case0 = prev[j]
                case1 = 0
                if j - coins[i - 1] >= 0:
                    case1 = curr[j - coins[i - 1]]
                curr[j] = case0 + case1
                prev = curr

        return prev[amount]



s = Solution()
print(s.change(5,[1,2,5]))