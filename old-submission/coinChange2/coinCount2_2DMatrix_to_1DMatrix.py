class Solution:
    
    def getCoinCounts(self,coinsList,amt,index):
        
        '''
        Compare it with 2D matrix approach and visualize
        '''
        
        # Create a list
        dummyMatrix = [0]*(amt+1)
        dummyMatrix[0] = 1 # for 0th coin
        
        # Iterate the coinsList and compare it with dummyMatrix
        for i in range(0,len(coinsList)):
            for j in range(0,len(dummyMatrix)):
                
                if j < coinsList[i]:
                    # currentAmt < currentCoin; do-nothing
                    # Compy everything from above - 2D matrix approach
                    pass
                
                elif j >= coinsList[i]:
                    # currentAmt >= currentCoin; sum (above + (j-currentCoin))
                    sum = dummyMatrix[j] + dummyMatrix[j-coinsList[i]]
                    dummyMatrix[j] = sum
        
        '''
        for m in dummyMatrix:
            print(m)
        '''
        return dummyMatrix[amt]         
    
    def getSolution(self,coinsList,amount,index=0):
        return self.getCoinCounts(coinsList, amount, index)

sol = Solution()
print(sol.getSolution([1,5,2],5))