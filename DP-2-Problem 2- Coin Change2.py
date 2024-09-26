"""
 FAANMG Problem #23 {Medium}

518. Coin Change 2


Time Complexity : O(MN)
 

Space Complexity : O(MN)

M = Number of coins
N = Amont denomination

Did this code successfully run on Leetcode : Yes


2D matrix is used to store the number of coins based on the amount chnages
the column represent the amount from 0
and the row consist of the different coins

The value of a particular cell is calculated as follows:
    
For the value of Jth column and ith row 
  untill j < coins[i-1] : dp[i][j] = dp[i-1][j] the value from above row
    else:
       the addition of the of above value and the value 1 + dp[i][j- coins[i-1]]
       
                    dp[i][j] = dp[i-1][j] + dp[i][ j - coins[i-1]]
                    
                    
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
        if(len(coins)== 0):
            return 0
        
        m = len(coins)
        n = amount
        
        col = n+1
        row= m+1
        
        dp= [[0]*col for _ in range (row)]
        
        
        dp[0][0] = 1
        
        for i in range (1 , row):
            for j in range(col):
                
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][ j - coins[i-1]]
                    
        return dp[m][n]
    
    

"""
 FAANMG Problem #23 {Medium}

518. Coin Change 2


Time Complexity : O(MN)
 

Space Complexity : O(N)

M = Number of coins
N = Amont denomination

Did this code successfully run on Leetcode : Yes


Above soln but using 1D array of size N eqaul to the amount count
                     
                    
@name: Rahul Govindkumar_RN27JUL2022
"""



class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        
        if(len(coins)== 0):
            return 0
        
        m = len(coins)
        n = amount
        
        col = n+1
        row= m+1
        
        dp= [0]*col
        
        
        dp[0] = 1
        
        for i in range (1 , row):
            for j in range(col):
                
                if(j >= coins[i-1]):
                    dp[j] = dp[j] + dp[ j - coins[i-1]]
                    
        return dp[n]