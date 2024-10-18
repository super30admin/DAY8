class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
      #     R.   B     G
      
      # 1.  17.  2.    17 

      # 2.  16.  16.    5

      # 3.  14    3    19

      if costs == None or len(costs) == 0:
        return -1

      n = len(costs)

      for i in range(1,n):
        costs[i][0] += min(costs[i-1][1], costs[i-1][2])
        costs[i][1] += min(costs[i-1][0], costs[i-1][2])
        costs[i][2] += min(costs[i-1][1], costs[i-1][0])
      print(costs)
      
      return min(costs[-1])
      
    #   return min( self.recurse(costs, 0,color) for color in range(3))


    # def recurse(self, costs:List[List[int]], house:List[int], color:int) -> int:
    #   #Base
    #   if house == len(costs):
    #     return 0
      
    #   total_cost = costs[house][color]
    #   # Logic

    #   next_colors = [0, 1, 2]
    #   if color == 0:
    #     cost = min(self.recurse(costs, house+1, 1),
    #               self.recurse(costs, house+1, 2))
    #   if color == 1:
    #     cost = min(self.recurse(costs, house+1, 2),
    #               self.recurse(costs, house+1, 0))
    #   if color == 2:
    #     cost = min(self.recurse(costs, house+1, 1),
    #               self.recurse(costs, house+1, 0))

    #   total_cost += cost
      
    #   return total_cost



      


      