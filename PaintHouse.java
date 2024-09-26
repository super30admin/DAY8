// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// approach
// 1) The cost till an element = element + minimum of previous row element cost with other two columns than previous choosen element column
// 2) print minimum element from the last row
public class PaintHouse {
	
	public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int m=costs.length; 
        for(int i=1;i<m;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[m-1][0], Math.min(costs[m-1][1],costs[m-1][2]));
    }

	public static void main(String[] args) {
		PaintHouse obj = new PaintHouse();
		int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		int res = obj.minCost(costs);
		System.out.println(res);
	}

}
