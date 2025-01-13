'''
Find the total pairs available to reach-out the coin count
'''
class Solution:
    
    def getCoinCounts(self,coinsList,amt,index):
        
        #base-case
        if amt == 0:
            return 1
            
        elif (amt <0) or (index == len(coinsList)):
            return 0
        
        #actual-case
        
        # Case 1: Ignore the coinsList[i]
        case1 = self.getCoinCounts(coinsList,amt,index+1)
            
        # Case 2: Pick-up the coinsList[i]
        case2 = self.getCoinCounts(coinsList, (amt-coinsList[index]), index)
            
        # Sum up case-1 and case-2 and return
        return (case1+case2)          
                    
    
    def getSolution(self,coinsList,amount,index=0):
        return self.getCoinCounts(coinsList, amount, index)

sol = Solution()
print(sol.getSolution([1,2],3))