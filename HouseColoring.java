/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Paint houses using 3 colors R,G,B such that no houses are adjacent to each other.

//If we start painting houses from the first rows, we might end up having repeated subproblems 


//Time Complexity would be O(n*3) and space complexity would be O(1) if space is maintained and O(n^2) if two dimensional dp table is maintained. 

public class HouseColoring {

	/**
	 * @param args
	 */

	public static int min_cost_dp(int[][] cost) {
		
		//Creating a dp table for the problem 
		int min=0;
		int length = cost.length-1;
		int[][] dp = new int[cost.length][3];
		
		for(int j=0;j<cost[0].length;j++) {
			
			dp[0][j] = cost[0][j];
		//	System.out.println(dp[0][j]);
			}
		
		for(int i=1;i<cost.length;i++) {
			
			dp[i][0] = cost[i][0] +  Math.min(dp[i-1][1], dp[i-1][2]);//Check first and second col
			dp[i][1] = cost[i][1] +  Math.min(dp[i-1][0], dp[i-1][2]);//Check zeroeth and second col
			dp[i][2] = cost[i][2] +  Math.min(dp[i-1][0], dp[i-1][1]);//Check zeroeth and first col
			
		}
		
		min = Math.min(Math.min(dp[dp.length-1][0], dp[dp.length-1][1]),dp[dp.length-1][2]);//Find min of the last row
		
		return min;
	}
	
	
	
	
	
	//Assuming if the input can be mutated
	public static int min_cost(int[][] cost) {
		int min=0;
		int length = cost.length-1;
		
		
		for(int i=1;i<cost.length;i++) {
			
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);//Check for cols 1 and 2 
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);//Check for cols 0 and 2
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);//Check for cols 0 and 1 
			
		}
		
		min = Math.min(Math.min(cost[length][0], cost[length][1]),cost[length][2]);// Find min of last row
		
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] cost = new int[][] {{17,2,17},{16,16,5},{14,3,19}};
		
	
		int minimum2= min_cost_dp(cost);
		int minimum=min_cost(cost);
		System.out.println(minimum);
		System.out.println(minimum2);
	}

}
