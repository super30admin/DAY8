
#256. Paint House
#TC-O(M*n)
#SC->O(1)


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs == None or len(costs) == 0 or len(costs[0])==0 ):
            return 0
        for m in range(1,len(costs)):
            
            costs[m][0] = min((costs[m][0]+costs[m-1][1]),(costs[m][0]+costs[m-1][2]))
            costs[m][1] = min((costs[m][1]+costs[m-1][0]),(costs[m][1]+costs[m-1][2]))
            costs[m][2]= min ((costs[m][2]+costs[m-1][0]),(costs[m][2]+costs[m-1][1]))
            
        return(min(costs[len(costs)-1]))
       
            
        
      