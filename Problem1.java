// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// As we add the cost painting at each element+ minimun od the cost paiting the alternative house, bottom up.
// In the end minimun cost of painting amoung the 3 houses is returned as the solution

class Solution {
    public int minCost(int[][] costs) {
        for(int i=costs.length-2;i>=0;i--){
            costs[i][0]+=Math.min(costs[i+1][1],costs[i+1][2]);
            costs[i][1]+=Math.min(costs[i+1][0],costs[i+1][2]);
            costs[i][2]+=Math.min(costs[i+1][1],costs[i+1][0]);
        }
         if (costs.length == 0) return 0; 
         return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}