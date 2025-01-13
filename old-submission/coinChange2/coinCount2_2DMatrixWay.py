class Solution:
    
    def getCoinCounts(self,coinsList,amt,index):
        
        # Set-up a 2D matrix
        rows = len(coinsList) +1
        cols = amt+1
        matrix = [[None for j in range(0,cols)] for i in range(0,rows)]
        
        # Fill up the the following
        # 1. Dummy coin 0 row with all 1
        # 2. Col 0 with all 1's
        
        for i in range(0,rows):
            matrix[i][0] = 1
        
        for j in range(1,cols):
            matrix[0][j] = 0
        
            
        # Fill up the ways in the matrix
        for i in range(1,rows):
            
            for j in range(1,cols):
                
                # Case1: j < coinsList[i-1] i.e. "amt" < "currentCoin"
                # Pick up everything from above row and same column
                if j < coinsList[i-1]:
                    matrix[i][j] = matrix[i-1][j]
                
                # Case 2: "amt">="currentCoin"
                else:
                    # sum (above + matrix[rowPtr-coinSelected])
                    above = matrix[i-1][j]
                    sameRow = matrix[i][j - coinsList[i-1]]
                    matrix[i][j] = above + sameRow
            
        '''
        for m in matrix:
            print(m)
        '''     
        return matrix[rows-1][cols-1]
                    
    
    def getSolution(self,coinsList,amount,index=0):
        return self.getCoinCounts(coinsList, amount, index)

sol = Solution()
print(sol.getSolution([1,2,5],5))