"""
DP-2

Problem1(https://leetcode.com/problems/paint-house/)

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
 
Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000

Time Complexity : O(mxn)
Space Complexity : O(mxn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Since we're having repeatitive sub problems we're going to store them by creating a dp 2D array of m(coins+1) x n(amount+1) size to store the 0th result. Default values will be 0 but we store 
the col 0 values as 1 as these are the final results which indicates we have found the answer in respective coins. Now we start iterating the coins & amount & check if current coin is greater than
amount if yes then we take the previous result in the current result since we can't form amount with the current coin else we add the previous result along with the current result which is dp[i][j-coins[i-1]]
which indicates amount - current coin result. After the iteration, we'll find our answer in the dp[len(coins)len(amount)].
"""


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if len(coins) == 0 or amount < 0:
            return 0

        dp = [[0] * (amount+1) for _ in range(len(coins)+1)]

        for i in range(len(coins)+1):
            dp[i][0] = 1

        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
        
        return dp[len(coins)][amount] if dp[len(coins)][amount] != 0 else 0
        