// Time Complexity : O(m), m is the no of rows in the matrix
// Space Complexity : O(1), manipulating the input array itself
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PaintHouse {
    public int minCost(int[][] costs) {
        int m = costs.length;

        for(int i = m-2; i >= 0; i--) {
            costs[i][0] = costs[i][0]+Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1]+Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2]+Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }
}