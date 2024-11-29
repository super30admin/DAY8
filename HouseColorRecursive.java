// Time Complexity : 3^n .n is the length of the array
// Space Complexity O(n). 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : No


public class HouseColorBruteForce {

	public static void main(String[] args) {

		HouseColorBruteForce houseColor = new HouseColorBruteForce();
		int firstColorComputation = houseColor.
				minCost(new 
						int[][] {{17,2,17},{16,16,5},{14,3,19}},
						0,0,0);
		int secondColorComputation = houseColor.
				minCost(new 
						int[][] {{17,2,17},{16,16,5},{14,3,19}},
						0,0,1);
		int thirdColorComputation = houseColor.
				minCost(new 
						int[][] {{17,2,17},{16,16,5},{14,3,19}},
						0,0,2);
		System.out.println(Math.min(Math.min(firstColorComputation,
				secondColorComputation), thirdColorComputation));
	}
	
	public int minCost(int[][] costs,int min,int row,int color) {
		
		if(row==costs.length) return min;
		
		int case1=Integer.MAX_VALUE;
		int case2 = Integer.MAX_VALUE;
		int case3 = Integer.MAX_VALUE;
		
		if(color==0) {
			case1 = Math.min(minCost(costs, min+costs[row][1], row+1, 1), 
					minCost(costs, min+costs[row][2], row+1, 2));
		}
		if(color==1) {
			case1 = Math.min(minCost(costs, min+costs[row][0], row+1, 0), 
					minCost(costs, min+costs[row][2], row+1, 2));
		}
		if(color==2) {
			case1 = Math.min(minCost(costs, min+costs[row][1], row+1, 1), 
					minCost(costs, min+costs[row][0], row+1, 0));
		}
		
		
		int length = costs.length-1;
		return Math.min(case1, Math.min(case2, case3));
	}
}
