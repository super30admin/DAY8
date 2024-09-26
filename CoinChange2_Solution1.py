# -*- coding: utf-8 -*-
"""
Created on Fri Jan  3 16:53:31 2020

@author: WELCOME
"""
"""
Time Complexity = O(M*N)
Space Complexity = O(M*N)
"""


class Solution:
    def change(self, amount: int, coins):
        if amount==0:
            return 1
        list1=[]
        for i in range(len(coins)+1):
            list2=[]
            for j in range(amount+1):
                list2.append(0)
            list1.append(list2)
        
        for i in range(1,len(coins)+1):
                list1[i][0]=1
        
            
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if amount<coins[i-1]:
                    list1[i][j]=list1[i-1][j]
                else:
                    list1[i][j]=list1[i-1][j]+list1[i][j-coins[i-1]]
                
        return list1[-1][-1]
    
temp=Solution()
print(temp.change(5,[1,2,5]))