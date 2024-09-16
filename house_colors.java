// Time Complexity : O(N), N = number of houses
// Space Complexity : O(1), no extra data structure used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve problem before class. Still have doubts grasping these type of problems.


// Your code here along with comments explaining your approach: Same as class

class Solution {
    public int minCost(int[][] costs) {
        
        if(costs == null || costs.length == 0) return 0;
        
        int n = costs.length -1;
        for(int i=1; i< costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
            
        }
        
        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }
}
