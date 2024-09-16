# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if costs == None or len(costs) == 0:
            return 0
        
        n =len(costs)
        
        r = costs[0][0]
        b = costs[0][1]
        g = costs[0][2]
        
        for i in range(1,n):
            temp_r = r
            temp_b = b
            r = min(b,g) + costs[i][0]
            b = min(temp_r,g) + costs[i][1]
            g = min(temp_r,temp_b) + costs[i][2]
            
        return min(min(r,b),g)