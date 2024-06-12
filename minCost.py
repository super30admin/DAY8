#Time Complexity=O(m*3)=O(m),m-number of houses n=3-length of the array having cost for each house to paint
#Space Complexity=O([m+1]*3)=O(m)=m=length of the houses
#Ran successfully in Leetcode:Yes
#Here we first take alternate indices and calculate the min vost and store in an array. Then from each row of the array we choose min value and add them up to give solution.
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if not costs:
            return 0
        if len(costs)==0:
            return 0
        n=len(costs)-1
        for i in range(1,len(costs)):
            costs[i][0]+=min(costs[i-1][2],costs[i-1][1])
            costs[i][1]+=min(costs[i-1][0],costs[i-1][2])
            costs[i][2]+=min(costs[i-1][0],costs[i-1][1])
        return min(costs[n][0],costs[n][1],costs[n][2])
        
