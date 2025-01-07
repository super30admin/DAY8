// Time Complexity : O (n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes

// For each house, calculate the min costs so far
// The final "layer" will give us the min costs for each color
// return the min of these
class PaintHouse {
    public int minCost(int[][] costs) {
        int[] curr = costs[0];
        int[] prev = costs[0];
        int i;
        for(i = 1; i < costs.length; i++) {
            curr = findMin(prev, costs[i]);
            prev = curr;
        }
        return Math.min(curr[0], Math.min(curr[1], curr[2]));
    }

    public int[] findMin(int[] prev, int[] cost) {
        int[] res = new int[3];
        res[0] = cost[0] + Math.min(prev[1], prev[2]);
        res[1] = cost[1] + Math.min(prev[2], prev[0]);
        res[2] = cost[2] + Math.min(prev[0], prev[1]);
        return res;
    }
}