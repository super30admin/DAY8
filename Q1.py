######### Paint Houses

# Time Complexity : O(n) where n is the number of houses
# Space Complexity : O(n) where n is the number of houses
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# in a bottom up manner based on the current house and the color keep picking the previous houses color. At the end pick the minimum for all possible costs of the first house.

def paint_houses(costs):
	if not costs:
		return 0
	for i in reversed(range(len(costs)-1)):
		costs[i][0] +=  min(costs[i+1][1], costs[i+1][2])
		costs[i][1] +=  min(costs[i+1][0], costs[i+1][2])
		costs[i][2] +=  min(costs[i+1][1], costs[i+1][0])
	return min(costs[0][0], costs[0][1], costs[0][2])
