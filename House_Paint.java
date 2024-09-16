// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class House_Paint {
	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		int min_cost = minCost(costs);
		System.out.println("The minimum cost of the house is : " + min_cost);
	}

	public static int minCost(int[][] costs) {
		// Edge case is handled
		if (costs == null || costs.length == 0) {
			return 0;
		}
		/*
		 * In this loop we get the cost to color in each index of the row, by comparing
		 * the minimum cost in the previous rows with different colors and adding it to
		 * the index of the current row
		 */
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}
		/*
		 * In the end we return minimum value present in the last row
		 */
		return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
	}
}