"""Time = O(mn), n = 3
ie
O(m), Space: O(1)"""


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        costR = costs[len(costs) - 1][0]  # row and col
        costB = costs[len(costs) - 1][1]
        costG = costs[len(costs) - 1][2]

        for i in range(len(costs) - 2, -1, -1):
            tempR = costR  # to store previous val so that we can use it while update
            tempB = costB
            tempG = costG

            costR = costs[i][0] + min(tempB, tempG)
            costB = costs[i][1] + min(tempR, tempG)
            costG = costs[i][2] + min(tempR, tempB)

        return min(costR, min(costB, costG))






