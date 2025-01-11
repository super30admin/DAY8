#Time complexity: O(n)
#Space complexity: O(1)
#Leetcode: Yes

if len(costs) == 0:
  print(0)

for i in range(len(costs)-2,-1,-1):
  costs[i][0] = min(costs[i+1][1]+costs[i][0],costs[i+1][2]+costs[i][0])
  costs[i][1] = min(costs[i+1][0]+costs[i][1],costs[i+1][2]+costs[i][1])
  costs[i][2] = min(costs[i+1][0]+costs[i][2],costs[i+1][1]+costs[i][2])

print(min(costs[0][0],costs[0][1],costs[0][2]))