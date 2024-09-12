#LC 256 - Paint House
#Time Complexity - O(n) Not sure, can you comment?
#Space Complexity - O(n)
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) == 0:
            return 0
        
        if len(costs) == 1:
            return min(costs[0])
        
        def helper(costs,red,blue,green,index):
            #print(red,green,blue,index)
            if index == len(costs):
                #print(red,blue,green)
                return min(red,green,blue)
            tred = costs[index][0] + min(green,blue)
            tblue = costs[index][1] + min(green,red)
            tgreen = costs[index][2] + min(red,blue)
            #print(tred,tblue,tgreen)
            ans = helper(costs,tred,tblue,tgreen,index+1)
            return ans
        return helper(costs,costs[0][0],costs[0][1],costs[0][2],1)