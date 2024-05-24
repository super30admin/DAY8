# Time Complexity : O(n), where n is the number of houses
# Space Complexity: O(1)
class Solution:
    def housePaint(self, costs: list[list[int]]) -> int:
        if not costs:
            return 0
        # Intializing the colors with the bottom row costs
        red = costs[len(costs)-1][0];
        blue = costs[len(costs)-1][1];
        green = costs[len(costs)-1][2];
        for i in range(len(costs)-2, -1, -1):
            tempRed = red
            tempBlue = blue
            # Cost of one color will be the sum of the cost of that color plus the min of the cost of the other two colors for the other two houses so far
            red = costs[i][0] + min(blue, green)
            blue = costs[i][1] + min(tempRed, green)
            green = costs[i][2] + min(tempRed, tempBlue)
            
        
        return min(red, blue, green) # Min of the costs in the top row for the 3 colors

# Example 1
sol = Solution()
costs = [[17, 2, 17],[16, 16, 5],[14, 3, 19]]
print(sol.housePaint(costs))  # Expected output: 10

# Example 2
costs = [[7, 6, 2],[1, 3, 4],[5, 8, 3]]
print(sol.housePaint(costs))  # Expected output: 6

# Example 3
costs = [[5, 8, 6],[19, 14, 13],[7, 5, 12],[14, 15, 17],[3, 20, 10]]
print(sol.housePaint(costs))  # Expected output: 43

# Example 4
costs = [[20, 18, 4],[9, 9, 6],[18, 19, 9],[8, 12, 5]]
print(sol.housePaint(costs))  # Expected output: 30

