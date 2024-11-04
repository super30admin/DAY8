class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        matrix = costs.copy()
        for i in range(1, len(costs)):
            matrix[i][0] = min(matrix[i][0]+matrix[i-1][1], matrix[i][0]+matrix[i-1][2])
            matrix[i][1] = min(matrix[i][1]+matrix[i-1][0], matrix[i][1]+matrix[i-1][2])
            matrix[i][2] = min(matrix[i][2]+matrix[i-1][0], matrix[i][2]+matrix[i-1][1])
        return min(matrix[-1][0],min(matrix[-1][1],matrix[-1][2]))


