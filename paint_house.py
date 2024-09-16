# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : No.(couldn't access the Problem)

# Any problem you faced while coding this : No

'''
1. I have used a Table Approach as described in the lecture
2. Any particular element A[i][j] can be part of min cost, either but it has to come through the element in the previous row at A[row-1][col '+ or -' 1] 

3. Leveraging that idea I use a top down approach while also calculating the cumulative min sum at each element so that it can be re-used.
'''


def mincost(costs):

	if costs == None or len(costs) == 0:
		return 0

	rows = len(costs)

	for i in range(rows):

		costs[i][0] += min(costs[i-1][1] + costs[i-1][2])
		costs[i][1] += min(costs[i-1][0] + costs[i-1][2])
		costs[i][2] += min(costs[i-1][0] + costs[i-1][1])

	return min(costs[row-1])