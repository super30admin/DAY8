"""
Time Complexity: 0(2^(coins+amount))
Space Complexity: 0(2^(coins+amount)
Approach: Brute Force Exhaustive -- choose not choose
"""
class Solution:

    def __chooseNotChoose(self, coins: List[int], idx:int, amount):
        
        # base-case
        if idx == len(coins):
            return 0
        
        if idx != len(coins) and amount < 0:
            return 0
        
        if amount == 0:
            return 1

        # logic-case

        choose = self.__chooseNotChoose(coins, idx, amount-coins[idx])
        notChoose = self.__chooseNotChoose(coins, idx+1, amount)

        return (choose+notChoose)

    def change(self, amount: int, coins: List[int]) -> int:
        idx = 0
        
        return self.__chooseNotChoose(coins, idx, amount)