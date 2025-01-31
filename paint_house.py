'''
Time Complexity :
O(n)
Space Complexity : O(n*3)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

n = len(costs)
        
for i in range(1, n):
    # Update costs in place
    costs[i][0] += min(costs[i-1][1], costs[i-1][2])
    costs[i][1] += min(costs[i-1][0], costs[i-1][2])
    costs[i][2] += min(costs[i-1][0], costs[i-1][1])

# Return the minimum cost of painting the last house with any color
return min(costs[-1])