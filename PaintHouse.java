// Time Complexity : O(n).n is the length of the array
// Space Complexity O(1). 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


public class HouseColor {
	public static void main(String[] args) {

		HouseColor houseColor = new HouseColor();
		System.out.println(houseColor.minCost(new int[][] {{17,2,17},{16,16,5},{14,3,19}}));
	}
	
	public int minCost(int[][] costs) {
	
		if(costs==null || costs.length==0) return 0;
		
		for(int i=1;i<costs.length;i++) {
			costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
			costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
			costs[i][2]+=Math.min(costs[i-1][1],costs[i-1][0]);
		}
		
		int length = costs.length-1;
		return Math.min(costs[length][0], Math.min(costs[length][1], costs[length][1]));
	}
	
	
}

