// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    /*
    [3,5,3],
    [9,20,6],
    [7,13,18],
    [9,10,18]
    */

    public static  int minCost(int[][] cost) {
        for(int i = 1;i<cost.length;i++){
            cost[i][0] = cost[i][0] + Math.min(cost[i-1][1],cost[i-1][2]) ;
            cost[i][1] = cost[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = cost[i][2] + Math.min(cost[i-1][1], cost[i-1][0]);
        }

        return Math.min(cost[cost.length-1][0], Math.min(cost[cost.length-1][1], cost[cost.length-1][2]));
    }
}