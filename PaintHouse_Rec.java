// Time Complexity : 3*O(2^n) --> where n is number of houses
// Space Complexity : O(n + m) --> where m is number of color
// Did this code successfully run on Leetcode (256): Yes
// Any problem you faced while coding this : Yes, did not understand it well.


// Your code here along with comments explaining your approach

class Solution {
	public int minCost(int costs[][]) {
		
		int case1 = helper(costs, 0, 0, 0);
		int case2 = helper(costs, 0, 0, 1);
		int case3 = helper(costs, 0, 0, 2);
		
		return Math.min(case1, Math.min(case2, case3));
	}
	
	private int helper(int costs[][], int min, int row, int lastColor) {
		// base case
		if (row == costs.length) return min;
		
		//logic
		int case1 = Integer.MAX_VALUE;
		int case2 = Integer.MAX_VALUE;
		int case3 = Integer.MAX_VALUE;
		
		if (lastColor == 0){
			case1 = Math.min(
				helper(costs, min + costs[row][1], row + 1, 1),
				helper(costs, min + costs[row][2], row + 1, 2)
			);
		}
		
		if (lastColor == 1){
			case2 = Math.min(
				helper(costs, min + costs[row][0], row + 1, 0),
				helper(costs, min + costs[row][2], row + 1, 2)
			);
		}
		
		if (lastColor == 2){
			case3 = Math.min(
				helper(costs, min + costs[row][1], row + 1, 1),
				helper(costs, min + costs[row][0], row + 1, 0)
			);
		}
		return Math.min(case1, Math.min(case2, case3));
	}
}