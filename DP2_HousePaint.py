Time complexity: O(n)
Space complexity: O(1)
Executed in Leetcode: Yes
Challenges: No, as I attended this  class before.

Comments: If a house is painted red, the cost of painting red is added to the cost of painting the next house (which is the minimum
from the other 2 colors - blue and green). Similarly, each cost of painting a house green or blue is calculated. Finally,
the minimum value from first row gives the minimum cost of painting the houses.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # Boundary condition
        if len(costs) == 0:
            return 0
        
        for n in reversed(range(len(costs)-1)):
            
            # Total cost when nth house is painted red
            costs[n][0] += min(costs[n + 1][1], costs[n + 1][2])
            
            # Total cost when nth house is painted green.
            costs[n][1] += min(costs[n + 1][0], costs[n + 1][2])
            
            # Total cost when nth house is painted blue
            costs[n][2] += min(costs[n + 1][0], costs[n + 1][1])

   
        return min(costs[0]) # Return the minimum value from first row
        
