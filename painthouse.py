class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        n = len(costs)
        dp_table = [[0 for i in range(3)] for j in range(n)]
        dp_table[0] = costs[0]
        
        for i in range(1, len(costs)):
            dp_table[i][0] = costs[i][0] + min(dp_table[i-1][1], dp_table[i-1][2])
            dp_table[i][1] = costs[i][1] + min(dp_table[i-1][0], dp_table[i-1][2])
            dp_table[i][2] = costs[i][2] + min(dp_table[i-1][0], dp_table[i-1][1])
        
        return min(dp_table[n-1])
        