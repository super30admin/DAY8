"""
Time Complexity: O(n * 3) -- n is count of rows
Space Complexity: 0(3) -- result of size 3 + temp variables constant
Approach: Memorization -- DP
"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # initialize rows
        rows = len(costs)


        # initialize result of size 3 -- R,G,B colors
        result = [costs[-1][0], costs[-1][1], costs[-1][2]]

        # iterate and get the result
        for r in range(rows-2, -1, -1):

            # case-0
            temp_0 = result[0]
            result[0] = costs[r][0] + min(result[1], result[2])
            
            # case-1
            temp_1 = result[1]
            result[1] = costs[r][1] + min(temp_0, result[2])

            # case-2
            result[2] = costs[r][2] + min(temp_0, temp_1)
        
        # end of for loop

        return min( result[0], min(result[1], result[2]))