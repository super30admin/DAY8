#############256. Paint House###################################################################################################################################################################
// Time Complexity : done in 2 ways - recursion: 2^(number of houses) and matrix: number of houses X color
// Space Complexity : recursion: not sure for recursion ad matrix: mXn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : solved after class, so have better idea


// Your code here along with comments explaining your approach in three sentences only
1 way used is recursion and another is once brute force place is played out implemented matrix 

##############recursion###############
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        #n=len(costs)
        #color=len(costs[0])
        costred=self.bruteforce(costs,0,0)
        print('costgreen')
        costblue=self.bruteforce(costs,0,1)
        costgreen=self.bruteforce(costs,0,2)
        print(costred,costblue,costgreen)
        return min(costred,costblue,costgreen)

    def bruteforce(self,costs,n,idx) -> int:
        m=len(costs[0])
        #base
        if n==len(costs): 
            return 0        
        #condition
        if idx==0:
            cost=costs[n][0] + min(self.bruteforce(costs,n+1,1),self.bruteforce(costs,n+1,2))
        if idx==1:
            cost=costs[n][1] + min(self.bruteforce(costs,n+1,0),self.bruteforce(costs,n+1,2))
        if idx==2:
            cost=costs[n][2] + min(self.bruteforce(costs,n+1,0),self.bruteforce(costs,n+1,1))
        #print('exit rec:',n,m,idx)
        return cost


###############Matrix##############
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        mat=costs
        print(mat)
        rows=len(mat)
        cols=len(mat[0])
        for i in range(1,rows):
            for j in range(cols):
                if j==0:
                    mat[i][j]=mat[i][j]+min(mat[i-1][1],mat[i-1][2])
                if j==1:
                    mat[i][j]=mat[i][j]+min(mat[i-1][0],mat[i-1][2])
                if j==2:
                    mat[i][j]=mat[i][j]+min(mat[i-1][1],mat[i-1][0])
        return min(mat[rows-1])     
        

#############518. Coin Change II####################################################################################################################################################################


// Time Complexity : done in 2 ways - recursion: 2^(number of coins+target) and matrix: number of coins X target
// Space Complexity : recursion: not sure for recursion ad matrix: mXn
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : solved after class, so have better idea


// Your code here along with comments explaining your approach in three sentences only
1 way used is recursion and another is once brute force place is played out implemented matrix 

##############Recursion##############
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        return self.bruteforce(amount, coins, 0)


    def bruteforce(self,amount,coins,idx) -> int:
        #base
        if amount==0:
            return 1
        if amount<0 or idx>=len(coins):
            return 0

        #select
        #print('case1 amount:',amount,' coins:',coins,' coin:',coins[idx])
        case1= self.bruteforce(amount-coins[idx], coins, idx)
        #print('case1:', case1)
        #no select
        #print('case2 amount:',amount,' coins:',coins,' coin:',coins[idx])
        case2= self.bruteforce(amount, coins, idx+1)
        #print('return:',case1,case2)
        return case1+case2

        


###############Matrix##############

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        rows=len(coins)+1
        cols=amount+1
        mat=[[0 for j in range(cols)] for i in range(rows)]
        mat[0][0]=1
        #print(mat)
        for i in range(1,rows):
            for j in range(cols):
                if j<coins[i-1]:
                    mat[i][j]=mat[i-1][j]
                else:
                    #print(i,j,mat[i-1][j],coins[i-1],mat[i][j-coins[i-1]])
                    mat[i][j]=mat[i-1][j]+mat[i][j-coins[i-1]]
        #print(mat)
        return mat[rows-1][cols-1]
        
        




  