# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : None

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs) - 1
        rcost = costs[n][0]
        gcost = costs[n][1]
        bcost = costs[n][2]

        for i in range(n - 1, -1, -1):

            rtemp = rcost
            gtemp = gcost

            rcost = min(gcost, bcost) + costs[i][0]

            gcost = min(rtemp, bcost) + costs[i][1]

            bcost = min(gtemp, rtemp) + costs[i][2]
            print(rcost, gcost, bcost)
        return min(rcost, min(gcost, bcost))