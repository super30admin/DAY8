// Time Complexity :brute force: O(2^2), dp: o(n) n = number of houses
// Space Complexity :brute force:O(n), dp:O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/**
 * https://leetcode.com/problems/paint-house/
 * 
 *Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or green. 
 *the cost for painting a particular house with a particular colour is going to be different. you have to colour the house
 * in such a way that no two adjacent houses will have the same colour. the cost for painting  a house with any colour is 
 * represented by a n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] and cost for 
 * painting house 4 with green colour is cost[4][2] and so on.....calculate the minimum cost to paint all houses. 
 * try to optimize it for space !! 
 */
public class PaintHouse {

	public static int minCost(int[][] costs) {
		
//		int case1 = bruteForce(costs, 0, 0, 0);
//		int case2 = bruteForce(costs, 0, 0, 1);
//		int case3 = bruteForce(costs, 0, 0, 2);
//		
//		return Math.min(case1, Math.min(case2, case3));
		
		return dpSolution(costs);
	}
	
	private static int dpSolution(int[][] costs) {
		if(costs == null || costs.length ==0) return 0;
		
		int n = costs.length;
		/**
		 * when we choose color 0 for current house, previous house must have chose color 1 or color 2
		 * so we choose min cost between those two for previous house and add to current house chosen color price
		 */
		for(int i=1 ;i<n; i++) {
			costs[i][0]+= (Math.min(costs[i-1][1], costs[i-1][2]));
			costs[i][1]+= (Math.min(costs[i-1][0], costs[i-1][2]));
			costs[i][2]+= (Math.min(costs[i-1][0], costs[i-1][1]));
		}

		/**
		 * since we have 3 colors, tree will have 3 roots
		 * last row will hold min cost for each root, take min out of it 
		 */
		
		return Math.min(costs[n-1][0], Math.min(costs[n-1][1], costs[n-1][2]));
	}
	private static int bruteForce(int[][] costs, int row, int min, int prevColor) {
		// base
		// if all houses are covered, we reached the end
		if(row == costs.length) return min;
		
		//logic
		int cost = 0;
		/**
		 * if previous color chosen is 0, we can choose color 1 or 2, cost of chosen color
		 * will get added into min, we take min from color1 and color2
		 */
		if(prevColor == 0) {
			cost = Math.min(bruteForce(costs, row + 1, min + costs[row][1], 1), 
					bruteForce(costs, row + 1, min+ costs[row][2], 2));
		}
		
		if(prevColor == 1) {
			cost = Math.min(bruteForce(costs, row + 1, min + costs[row][0], 0), 
					bruteForce(costs, row + 1, min + costs[row][2], 2));
		}
		
		if(prevColor == 2) {
			cost = Math.min(bruteForce(costs, row + 1, min + costs[row][0], 0), 
					bruteForce(costs, row + 1, min + costs[row][1], 1));
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}, {200,1,300}};
		System.out.println(minCost(costs));
	}
}
