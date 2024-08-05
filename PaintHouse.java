
// Time Complexity : O(n) n is number of houses (colours are 3 here which is constant)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

public class PaintHouse {
	public int minCost(int [][] costs) {
		int dp[][] = new int[costs.length][3];
		int n = costs.length;
		dp[n-1][0] = costs[n-1][0];
		dp[n-1][1] = costs[n-1][1];
		dp[n-1][2] = costs[n-1][2];
		for(int i=n-2;i>=0;i--) {
			dp[i][0] = costs[i][0]+ Math.min(dp[i+1][1], dp[i+1][2]);
			dp[i][1] = costs[i][1]+ Math.min(dp[i+1][0], dp[i+1][2]);
			dp[i][2] = costs[i][2]+ Math.min(dp[i+1][0], dp[i+1][1]);
		}
		return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
	}
	
	public static void main(String[] args) {
		int costs[][] = {{17,2,17},{16,16,5},{14,3,19}};
		PaintHouse paintHouse = new PaintHouse();
		System.out.println(paintHouse.minCost(costs));
		
	}
}
