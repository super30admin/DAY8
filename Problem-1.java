//basically sirs approach to the problem
//I messed up the array, we can do without it as well

//O(n^2) O(1)
class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;

        for(int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int res = costs[costs.length - 1][0];
        res = Math.min(res, costs[costs.length - 1][1]);
        res = Math.min(res, costs[costs.length - 1][2]);
        return res;
    }
}
