"""
// Time Complexity :O(n2) where n is denominations and money.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this :Failed when coins=[2]
and amount=[3] /UNHAPPY CASE

//Explanation:
create array of length amount+1
Store arr[0]
for each denomination,update the amount by coins required for that denomination
+coins required for the difference between money-denomination.

"""
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        money = [0 for amount in range(amount+1)]
        money[0] = 1
        for d in coins:
            for m in range(1,amount+1):
                if d <= m:
                    diff = m-d
                    money[m]=money[m]+money[diff]
        return money[amount]


if __name__ == "__main__":
  coins =[1 ,2,5]
  amount=11
  s=Solution()
  print("Required coins=",s.coinChange(coins,amount))
