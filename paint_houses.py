#Time Complexity = O(n)
#Space Complexity = O(1)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        # If there are no costs, return 0 as there's nothing to paint
        if not costs or len(costs) == 0:
            return 0
        
        n = len(costs)  # Number of houses

        # Start from the second-to-last house and work backwards
        for i in range(n - 2, -1, -1):
            # Update the cost for painting the current house red (0)
            # Add the current red cost to the minimum of the next house's blue and green costs
            costs[i][0] = costs[i][0] + min(costs[i + 1][1], costs[i + 1][2])
            
            # Update the cost for painting the current house blue (1)
            # Add the current blue cost to the minimum of the next house's red and green costs
            costs[i][1] = costs[i][1] + min(costs[i + 1][0], costs[i + 1][2])
            
            # Update the cost for painting the current house green (2)
            # Add the current green cost to the minimum of the next house's red and blue costs
            costs[i][2] = costs[i][2] + min(costs[i + 1][0], costs[i + 1][1])
        
        # Return the minimum cost among the three options for the first house
        return min(costs[0][0], min(costs[0][1], costs[0][2]))
