#This code defines a function minCost that calculates the minimum cost of painting a series of houses with three possible colors: red, green, and blue. Each house must be painted a different color from its adjacent houses. The function iterates through the list of painting costs for each house and updates three variables representing the cumulative minimum costs for painting the current house red, green, or blue. By the end of the loop, these variables contain the minimum possible costs for painting all the houses, and the function returns the smallest of these values. The algorithm runs in linear time, O(n), where n is the number of houses, and uses constant space, O(1), making it efficient in both time and space complexity.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        x = y = z = 0

        for r, g, b in costs:
            x, y, z = min(y, z) + r, min(x, z) + g, min(x, y) + b

        return min(x, y, z)