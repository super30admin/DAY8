// Time Complexity :O(n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :F!iguring out the minimum conecpt of how cost[i][0] 
//contributes to next for loop on cost[i-1][0]



 //Dynamic Programming

class Solution {
    public int minCost(int[][] costs) {
         if(costs==null||costs.length==0)
        return 0;
    
    for(int i=1; i<costs.length; i++){
        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
    }
    int n = costs.length-1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
}
    }
    
