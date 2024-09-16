
public class Problem_1 {
	 public int minCost(int[][] costs) {
	        // write your code here
	        
	        for(int i=1; i<costs.length; i++){
	            for(int j=0; j<costs[0].length; j++){
	                if(j == 0){
	                    costs[i][j] = costs[i][j] + Math.min(costs[i-1][j+1], costs[i-1][j+2]);
	                }else{
	                    costs[i][j] = costs[i][j] + Math.min(costs[i-1][j-1], costs[i-1][j+1]);
	                }
	            }
	        }
	        
	        int result = Math.min(costs[costs.length-1][2], Math.min(costs[costs.length-1][0], costs[costs.length-1][1]));
	        
	        return result;
	    }
}
