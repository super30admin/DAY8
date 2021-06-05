// Time Complexity : 3 * 2^n  = 2^n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yesy
// Any problem you faced while coding this :

class PaintHouse{
    public int minCost(int[][] costs) {
        for(int i = costs.length -2; i>=0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1])
        }
        return Math.min(costs[0,0], Math.min(costs[0,1], costs[0,2]));
    }

//    public int minCost(int[][] costs) {
//        int case1 = helper(costs, 0, 0, 0);
//        int case2 = helper(costs, 1, 0, 0);
//        int case3 = helper(costs, 2, 0, 0);
//        return Math.min(case1, Math.min(case2, case3));
//    }
//
//    private int helper(int[][] costs,  int color, int house, int minCost){
//        // base
//        if(house == costs.length)
//            return minCost;
//
//        // logic
//        if(color == 0)
//            return Math.min(helper(costs, 1, house+1, minCost + costs[house][0]),
//                            helper(costs, 2, house+1, minCost + costs[house][0]));
//
//        if(color == 1)
//            return Math.min(helper(costs, 0, house+1, minCost + costs[house][1]),
//                            helper(costs, 2, house+1, minCost + costs[house][1]));
//
//        if(color == 2)
//            return Math.min(helper(costs, 0, house+1, minCost + costs[house][2]),
//                            helper(costs, 1, house+1, minCost + costs[house][2]));
//
//        return -1;
//    }
}