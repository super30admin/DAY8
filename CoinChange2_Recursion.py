# -*- coding: utf-8 -*-
"""
Created on Tue Dec 31 17:21:09 2019

@author: WELCOME
"""
"""
RECURSIVE SOLUTION:

TIME COMPLEXITY = O(2^(M*N))
SPACE COMPLEXITY = O(M+N)

"""

class Solution:
    def change(self, amount, coins):
        if amount==0 and len(coins)==0:
            return 1
        return self.helper(amount,coins,0)
        
        
    def helper(self,amount,coins,index):
        
        #Base Case
        if amount<0 or index>=len(coins):
            return 0
        elif amount==0:
            return 1
        
        #Choose
        case1=self.helper(amount-coins[index],coins,index)
        
        #NotChoose
        case2=self.helper(amount,coins,index+1)
        
        return case1 + case2
    
temp=Solution()
print(temp.change(5,[1,2,5]))

        
