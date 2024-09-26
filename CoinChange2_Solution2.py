# -*- coding: utf-8 -*-
"""
Created on Fri Jan  3 18:06:36 2020

@author: WELCOME
"""
"""
Time Complexity = O(M*N)
Space Complexity = O(N)
"""



class Solution:
    def change(self, amount: int, coins):
        if amount==0:
            return 1
        list1=[0]*(amount+1)
        list1[0]=1
        for i in range(len(coins)):
            for j in range(coins[i],len(list1)):
                list1[j]=list1[j]+list1[j-coins[i]]
                
        return list1[-1]
    
temp=Solution()
print(temp.change(5,[1,2,5]))