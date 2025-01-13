class Solution:
    
    def calCost(self,matrix):
        # Iterate the matrix
        
        for i in range(len(matrix)-1,-1,-1):
            
            # If it's last row of the matrix, ignore it
            if i == len(matrix)-1:
                continue
            
            # For Red
            matrix[i][0] += min(matrix[i+1][1],matrix[i+1][2])
            
            # For Blue
            matrix[i][1] += min(matrix[i+1][0],matrix[i+1][2])
            
            # For Green
            matrix[i][2] += min(matrix[i+1][0],matrix[i+1][1])
        
        return matrix
        
    def getSolution(self,matrix):
        
        overrideMatrix = self.calCost(matrix)
        return min(overrideMatrix[0][0],overrideMatrix[0][1],overrideMatrix[0][2])

sol = Solution()
print(sol.getSolution(
    [
        [14,2,11],
        [11,14,5],
        [14,3,10]
    ]
))

print(sol.getSolution(
    [
        [17,2,17],
        [16,16,5],
        [14,3,19],
        [8,20,18]
    ]

))
