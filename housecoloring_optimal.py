# // Time Complexity :O(n)
# // Space Complexity :O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(len(costs)-1,0,-1):
                print(i)
                
                costs[i-1][0]=costs[i-1][0]+min(costs[i][1],costs[i][2])
                costs[i-1][1]=costs[i-1][1]+min(costs[i][0],costs[i][2])
                costs[i-1][2]=costs[i-1][2]+min(costs[i][1],costs[i][0])
                print(costs[i-1])
        return min(costs[0][0],costs[0][1],costs[0][2])
            