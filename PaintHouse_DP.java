// Time Complexity : O(n) --> where n is number of houses, as the color are fixed there will no O(m)
// Space Complexity : O(1) --> as we are mutating the same array
// Did this code successfully run on Leetcode (256): Yes
// Any problem you faced while coding this : Yes

// Explanation: In this 'Paint House' problem, we are mutating over the same array. We are iterating over the array from the 2nd row and for each index we are computing the minimum value from the other 2 colors of the upper row and adding the original value. In this manner we are filling up the rest of the array. At the end, we take the minimum value from last row which gives us the final ans. As the colors are fixed, we are just iterating over the rows and so the time complexity will be linear i.e. O(n).

// Your code here along with comments explaining your approach

class Solution {
	public int minCost(int costs[][]) {
		if (costs == null || costs.length == 0) return 0;
		int len = costs.length;
		
		for (int i = 1; i < len; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]); 
		}
		
		return Math.min(costs[len - 1][0], Math.min(costs[len - 1][1], costs[len - 1][2]));
	}
}