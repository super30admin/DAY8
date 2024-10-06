# Time Complexity = 2(m+n) 2 raise to power(m+n) | Space Complexity = O(m+n)

class Solution:
    def change(self, amount: int, coins: list[int]) -> int:
        return self.helper(amount, coins, 0)

    def helper(self, amount: int, coins: list[int], i: int):
        # base case

        if amount < 0 or i >= len(coins): return 0  # invalid case

        if amount == 0: return 1

        # logic
        case0 = self.helper(amount, coins, i + 1)  # invalid path case0 will have 0

        case1 = self.helper(amount - coins[i], coins, i)  # valid path case1 will have 1

        return case0 + case1
