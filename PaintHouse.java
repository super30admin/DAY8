// Time Complexity : O(n) where n is number of houses
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        
        for(int i=1;i<costs.length;i++)
        {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]); //pick minimum cost for each house by ignoring the 	 color that previous house has. Add this minimum to all the possible costs for the current house.
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
		//Final result would be minimum of the all costs of last house
        return Math.min(Math.min(costs[costs.length-1][0],costs[costs.length-1][1]),costs[costs.length-1][2]);
    }
}