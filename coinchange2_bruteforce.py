# // Time Complexity :O(2^n)
# // Space Complexity :O(2^n)
class Solution:
    def __init__(self):
        self.count=0
    def change(self, amount: int, coins: List[int]) -> int:
        self.helper(amount,coins,0)
        return self.count
    def helper(self,amount,coins,index):
        
        #base
        if amount==0:
            self.count+=1
            return
        if amount<0 or index==len(coins):
            return
        #logic
        
        #choose
        self.helper(amount-coins[index],coins,index)
        
        #not choose
        self.helper(amount,coins,index+1)
        
        