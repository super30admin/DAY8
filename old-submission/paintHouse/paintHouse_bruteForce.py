class Solution:
    
    def calCost(self,matrix,indexColor,row):
        
        # base case
        if row == len(matrix):
            return 0
        
        # actual case
        if indexColor == 0:
            return (min(self.calCost(matrix, 1, row+1),
                        self.calCost(matrix, 2, row+1))+
                        matrix[row][indexColor])
        
        elif indexColor == 1:
            return (min(self.calCost(matrix, 0, row+1),
                        self.calCost(matrix, 2, row+1))+
                        matrix[row][indexColor])
        
        elif indexColor == 2:
            return (min(self.calCost(matrix, 0, row+1),
                        self.calCost(matrix, 1, row+1))+
                        matrix[row][indexColor])
        
    def getSolution(self,matrix):
    
        costRed = self.calCost(matrix, 0, 0)
        costBlue = self.calCost(matrix, 1, 0)
        costGreen = self.calCost(matrix, 2, 0)
        
        print('Red:\t',costRed)
        print('Blue:\t',costBlue)
        print('Green:\t',costGreen)
        
        return min(costRed,costGreen,costBlue)
    
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