"""
 FAANMG Problem #22 {Easy}

256. Paint House


Time Complexity : O(N)
 

Space Complexity : O(1)



Did this code successfully run on Leetcode : Yes


we are starting from the last row and going upwards by :
    
    Here the loo is starting from the second last row
    
    As the conditions states :
        - You have to paint all the houses such that no two adjacent houses have the same color.
         - costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green,
         
    3 conditions for:
        Red selecting min for (blue, green ) of Next row below + current cost
        Green selecting min for (blue, red ) of Next row below + current cost
        Blue selecting min for (red, green ) of Next row below + current cost
        
    At the end themin for top row is calculated to get the minimum cost
    
                    
                    
@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if(len(costs)==0):
            return 0
        
        n = len(costs)
        
        for i in range (n-2, -1,-1):
         
            costs[i][0] = costs[i][0] + min(costs[i+1][1] , costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0] , costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][1] , costs[i+1][0])
        
        #print(costs[0][0], " ",costs[0][1]," " ,costs[0][2])
        return min(costs[0][0], min(costs[0][1],costs[0][2]))