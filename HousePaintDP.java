// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution{
	public int minCost(int[][] costs){
        //bottom up approach
		for(int i=costs.length-2; i>=0; i--){
            //cost of house if red
			costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            //cost of house if blue
			costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            //cost of house if green
			costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
		}

		return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
	}
}