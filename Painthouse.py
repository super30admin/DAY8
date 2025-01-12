'''
Recursive approach
# class Painthouse:
#     def recurse(self,costs, i,j,amount):
#         #base
#         if i==len(costs):
#             return amount
#         #logic
#         if j==0:
#             return min(self.recurse(costs,i+1,1,amount+costs[i][j]),self.recurse(costs,i+1,2,amount+costs[i][j]))
#         elif j==1:
#             return min(self.recurse(costs,i+1,0,amount+costs[i][j]),self.recurse(costs,i+1,2,amount+costs[i][j]))
#         else:
#             return min(self.recurse(costs,i+1,0,amount+costs[i][j]),self.recurse(costs,i+1,1,amount+costs[i][j]))
#     def minCost(self,costs):
#         if not costs:
#             return 0
#         return min(self.recurse(costs,0,0,0),self.recurse(costs,0,1,0),self.recurse(costs,0,2,0))
'''


def minCost(costs):
    for i in range(len(costs)-2,-1,-1):
        for j in range(3):
            if j==0:
                costs[i][j] += min(costs[i+1][1],costs[i+1][2])
            elif j==1:
                costs[i][j] += min(costs[i+1][0],costs[i+1][2])
            else:
                costs[i][j] += min(costs[i+1][0],costs[i+1][1])
    return min(costs[0])
print(minCost([[17,2,17],[16,16,5],[14,3,19]]))
