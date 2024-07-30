class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        m = len(costs)
        minRe = costs[m-1][0]
        minBl = costs[m-1][1]
        minGr = costs[m-1][2]

        for j in range(m-2, -1, -1):
            tempRe = minRe
            tempBl = minBl
            minRe = costs[j][0] + min(minBl, minGr)
            minBl = costs[j][1] + min(tempRe, minGr)
            minGr = costs[j][2] + min(tempRe, tempBl)

        return min(minRe, minBl, minGr)