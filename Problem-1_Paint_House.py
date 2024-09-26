# APPROACH 1: BRUTE FORCE (RECURSIVE) 
# Time Complexity : O(2 ^ n), n: number of houses (there will be three such trees, one for each color
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : NO (TIME LIMIT EXCEEDED)
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. It's recursive solution, with arguments - costs, current minimum cost, index (which house we are right now), previous color chosen (so that we don't choose the same one
#    here as adjacent houses can't be of same color.
# 2. there's a case for each previous color - choose the minimum cost of the other 2 colors and return them
# 3. Call this recursive function thrice where each case -> coloring the first home with R, B, G.

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        case_1 = self.helper(costs, 0, 0, 0)
        case_2 = self.helper(costs, 0, 0, 1)
        case_3 = self.helper(costs, 0, 0, 2)
        return min(case_1, case_2, case_3)
    
    def helper(self, costs, current_cost, ind, prev_color):
        
        if ind == len(costs):
            return current_cost
        
        #CASE: 1 (if last color was red)
        if prev_color == 0: 
            return min(self.helper(costs, current_cost + costs[ind][1], ind + 1, 1),
                         self.helper(costs, current_cost + costs[ind][2], ind + 1, 2))
            
        
        #CASE: 2 (if last color was blue)
        if prev_color == 1: 
            return min(self.helper(costs, current_cost + costs[ind][0], ind + 1, 0),
                         self.helper(costs, current_cost + costs[ind][2], ind + 1, 2))
            
            
        #CASE: 3 (if last color was green)
        if prev_color == 2: 
            return min(self.helper(costs, current_cost + costs[ind][1], ind + 1, 1),
                         self.helper(costs, current_cost + costs[ind][0], ind + 1, 0))
            
  
  

# APPROACH 2 : DYNAMIC PROGRAMMING 
# Time Complexity : O(n) - n: number of houses. (as we loop through costs matrix, there are only constant number of columns - colors)
# Space Complexity : O(1) - we reuse the input cost matrix
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. We store the dp results in the cost matrix itself as we need only the previous modified row.
# 2. The first row remains the same (as the cost to color the first house using any colors is same)
# 3. The next rows (till end), will be the cost of coloring the home with that color(column) + min(of coloring the previous homes such that the adjacent home is not the same 
#    color as the currrent one)

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if not costs:
            return 0
        
        for row in range(1, len(costs)):
            for col in range(len(costs[0])):
            
                if col == 0:
                    costs[row][col] += min(costs[row - 1][1], costs[row - 1][2])
                    
                elif col == 1:
                    costs[row][col] += min(costs[row - 1][0], costs[row - 1][2])
                    
                elif col == 2:
                    costs[row][col] += min(costs[row - 1][0], costs[row - 1][1])
                    
        return min(costs[-1])
