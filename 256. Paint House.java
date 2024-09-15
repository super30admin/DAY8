// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int minCost(int[][] costs) {
        int[] prev = new int[3];

        prev = costs[0];

        for(int i = 1; i < costs.length; i++){
            int[] curr = new int[3];
            curr[0] = costs[i][0] + Math.min(prev[1], prev[2]);
            curr[1] = costs[i][1] + Math.min(prev[0], prev[2]);
            curr[2] = costs[i][2] + Math.min(prev[0], prev[1]);
            prev = curr;
        }

        return Math.min(prev[0], Math.min(prev[1], prev[2]));        
    }
}
