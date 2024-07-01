"""
## Problem1(https://leetcode.com/problems/paint-house/)

"""

# Approach 1 : Greedy

class Solution:
    def helperFindHouse(self, costs, houseNo, colorIdx):
        #base case
        if (len(costs) == houseNo):
            return 0
        
        #Logic
        # case 1: when the color is RED
        if (colorIdx == 0):
            return costs[houseNo][0] + min(self.helperFindHouse(costs, houseNo + 1, 1), self.helperFindHouse(costs, houseNo + 1, 2))
        
        # case 2: when the color is BLUE 
        if (colorIdx == 1):
            return costs[houseNo][1] +  min(self.helperFindHouse(costs, houseNo + 1, 0), self.helperFindHouse(costs, houseNo + 1, 2))
                        
        # case 3: when the color is GREEN
        if (colorIdx == 2):
            return costs[houseNo][2] + min(self.helperFindHouse(costs, houseNo + 1, 0), self.helperFindHouse(costs, houseNo + 1, 1))     
                         
    def minCost(self, costs: List[List[int]]) -> int:
                                           
        redHouse = self.helperFindHouse(costs, 0 , 0)
        blueHouse = self.helperFindHouse(costs, 0 , 1)
        greenHouse = self.helperFindHouse(costs, 0 , 2)
                                           
        return min(redHouse, blueHouse , greenHouse)


# Approach - 2 TC : O(n) where n is number of houses, SC: O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        #print(n)
        redHouse = costs[n-1][0]
        blueHouse = costs[n-1][1]
        greenHouse = costs[n-1][2]
        #print(redHouse, blueHouse, greenHouse)
        for i in range(n-2, -1, -1):
            tempR = redHouse
            redHouse = costs[i][0] + min(blueHouse, greenHouse)
            
            tempB = blueHouse
            blueHouse = costs[i][1] + min(tempR, greenHouse)
            
          
            greenHouse = costs[i][2] + min(tempR, tempB)
            
            
            
        return min(redHouse, blueHouse, greenHouse)
         