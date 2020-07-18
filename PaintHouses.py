# Time complexity : O(n) where n is the number of houses
# Space complexity : O(mn) where m is the number of colors and n is the number of houses
# Initially I thought of using just a 1D array for storing the costs but then I didn't know how to keep track of the house of the previous house. So used a 2D array to find the minimum cost for every color at house i

class Problem2:
	def PaintHouse1(self, costs):
		# Using 2D array to store the costs
		# the array dimension is no.of colors X no.of houses
		paintCosts = [[0 for i in range(len(costs))] for j in range(len(costs[0]))]
		paintCosts[0][0] = costs[0][0]
		paintCosts[1][0] = costs[0][1]
		paintCosts[2][0] = costs[0][2]
		for i in range(1, len(costs)):
			paintCosts[0][i] = costs[i][0] + min(paintCosts[1][i - 1], paintCosts[2][i - 1])
			paintCosts[1][i] = costs[i][1] + min(paintCosts[0][i - 1], paintCosts[2][i - 1])
			paintCosts[2][i] = costs[i][2] + min(paintCosts[1][i - 1], paintCosts[0][i - 1])
		# First parameter is min cost of painting n - 1 houses with paining nth house red
		# First parameter is min cost of painting n - 1 houses with paining nth house blue
		# First parameter is min cost of painting n - 1 houses with paining nth house green
		return min(paintCosts[0][-1], paintCosts[1][-1], paintCosts[2][-1])

	def PaintHouse2(self, costs):
		# Using 1D array to store the costs
		# This approach doesn't work because if we take just min initially for the first house that might not lead us in the right path ahead
		# In the given example, if we take green for first house because its the min value, we won't be able to get the min cost for the second house(1+16). Instead if we paint the first house blue then we can paint the second house green which costs lesser than the first approach(2+1)
		paintCosts = []
		paintColor = []
		paintCosts.append(min(costs[0]))
		paintColor.append(costs[0].index(min(costs[0])))
		for i in range(1, len(costs)):
			if paintColor[i - 1] == 0:
				temp = [1, 2]
				temp_cost = [costs[i][1], costs[i][2]]
				paintCosts.append(min(temp_cost))
				paintColor.append(temp[temp_cost.index(min(temp_cost))])
			elif paintColor[i - 1] == 1:
				temp = [0, 2]
				temp_cost = [costs[i][0], costs[i][2]]
				paintCosts.append(min(temp_cost))
				paintColor.append(temp[temp_cost.index(min(temp_cost))])
			else:
				temp = [0, 1]
				temp_cost = [costs[i][0], costs[i][1]]
				paintCosts.append(min(temp_cost))
				paintColor.append(temp[temp_cost.index(min(temp_cost))])
		print(paintCosts)
		print(paintColor)
		return paintCosts[-1]

	def PaintHouse3(self, costs):
		# Using 2D array to store the costs
		# the array dimension is no.of houses X no.of colors
		paintCosts = [[0 for i in range(len(costs[0]))] for j in range(len(costs))]
		paintCosts[0][0] = costs[0][0]
		paintCosts[0][1] = costs[0][1]
		paintCosts[0][2] = costs[0][2]
		for i in range(1, len(costs)):
			paintCosts[i][0] = costs[i][0] + min(paintCosts[i - 1][1], paintCosts[i - 1][2])
			paintCosts[i][1] = costs[i][1] + min(paintCosts[i - 1][0], paintCosts[i - 1][2])
			paintCosts[i][2] = costs[i][2] + min(paintCosts[i - 1][0], paintCosts[i - 1][1])
		return min(paintCosts[-1])

	def PaintHouse4(self, costs):
		# Using a 1D array of constant size(number of colors)
		single_arr = [costs[0][0], costs[0][1], costs[0][2]]
		for i in range(1, len(costs)):
			temp1 = single_arr[0]
			temp2 = single_arr[1]
			single_arr[0] = costs[i][0] + min(temp2, single_arr[2])
			single_arr[1] = costs[i][1] + min(temp1, single_arr[2])
			single_arr[2] = costs[i][2] + min(temp1, temp2)
		return min(single_arr)

	def PaintHouse5(self, costs):
		# Using the costs array itself, performing an in place updation
		if len(costs) == 1:
			return min(costs[0])
		for i in range(1, len(costs)):
			costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
			costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
			costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
		return min(costs[-1])

if __name__ == '__main__':
	pH = Problem2()
	print(pH.PaintHouse1([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))
	#print(pH.PaintHouse2([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))
	print(pH.PaintHouse3([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))
	print(pH.PaintHouse4([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))
	print(pH.PaintHouse5([[17, 2, 1],[16,16,1],[14,3,19],[3,1,8]]))