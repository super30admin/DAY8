# Time Complexity : O(m*n) m-> len(coins) n->amount
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = {}
        def search(ix, amount):
            if (ix, amount) in memo:
                return memo[(ix, amount)]
            # base case
            if ix == len(coins) or amount < 0:
                return 0
            if amount == 0:
                return 1

            # logic
            choose = search(ix, amount - coins[ix])
            _choose = search(ix + 1, amount)

            memo[(ix,amount)] = choose + _choose

            return memo[(ix,amount)]
        
        return search(0,amount)