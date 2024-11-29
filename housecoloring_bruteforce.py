# // Time Complexity :O(2^n)
# // Space Complexity :O(2^n)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        caseR=self.helper(costs,0,0,0)
        caseB=self.helper(costs,0,0,1)
        caseG=self.helper(costs,0,0,2)
        return min(caseR,caseB,caseG)
    def helper(self,costs,index,s,color):
        #base
        if index==len(costs):
            return s
        #logic
        if color==0:
            return min(self.helper(costs,index+1,s+costs[index][0],1),self.helper(costs,index+1,s+costs[index][0],2))
        elif color==1:
            return min(self.helper(costs,index+1,s+costs[index][1],0),self.helper(costs,index+1,s+costs[index][1],2))
        elif color==2:
            return min(self.helper(costs,index+1,s+costs[index][2],1),self.helper(costs,index+1,s+costs[index][2],0))
            
        
        