# Time Complexity : O(n), n--> num houses
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
import math
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        memo = {}

        def search(house, color):
            if (house, color) in memo:
                return memo[(house,color)]
            #base case
            if house == len(costs):
                return 0
            #logic
            min_cost = math.inf
            for c in range(3):
                if c == color:
                    continue
                total_cost = search(house + 1, c) + costs[house][c]
                min_cost = min(min_cost, total_cost)
            
            memo[(house, color)] = min_cost

            return min_cost
        
        global_min = math.inf
        for c in range(3):
            total = search(0,c)
            global_min = min(global_min, total)
        
        return global_min