// Time Complexity : O(n)
// Space Complexity : Constant I suppose cause we aren't taking any extra space?
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Referred a video which explained this solution


// Your code here along with comments explaining your approach

class Solution {
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0){
            return 0;
        }
        
        for(int i =1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
            
        }
        
        return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
    }
}
