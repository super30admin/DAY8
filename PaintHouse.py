from typing import List
#Time Complexity = O(n)
#Space Complexity = O(1)
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        Costred = costs[n-1][0]
        Costblue = costs[n-1][1]
        Costgreen = costs[n-1][2]

        for i in range(n-2, -1, -1):
            tempr = Costred
            tempb = Costblue
            tempg = Costgreen
            Costred = costs[i][0] + min(Costblue,Costgreen)
            Costblue = costs[i][1] + min(tempr,Costgreen)
            Costgreen = costs[i][2] + min(tempr,tempb)
        return min(Costred,Costblue,Costgreen)