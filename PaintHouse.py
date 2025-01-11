# Time Complexity : O(n), where n is the number of houses
# Space Complexity : O(1), because we changed the original array, did not use any extra space
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Its a premium problem, I could not run it 

# Your code here along with comments explaining your approach:
class Solution:
    def minCost(costs):
        if costs is None:
            return 0
        
        # n is number of rows
        n = len(costs)
        # following bottom up approach, starting from the second last row
        # storing the values of the minimum of the other two colour costs for every house
        for i in range(n-2, 0, -1):
            # updating the costs at every index (every colour for every house)
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])

        # returning the minimum of the 3 computed total costs
        return min(costs[0][0], min(costs[0][1], costs[0][2]))
    

