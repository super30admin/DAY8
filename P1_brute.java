class Solution {
    public int minCost(int[][] cost) {
        int reR = helper(cost, 0, 0);
        int reB = helper(cost, 1, 0);
        int reG = helper(cost, 2, 0);
        
        return Math.min(reR, Math.min(reB, reG));
    }   

    private int helper(int[][] cost, int j, int i){
        //base
        if (i == cost.length) return 0;

        //logic
        //red color
        if (j == 0) {
            return cost[i][0] + Math.min(helper(cost, 1, i + 1), helper(cost, 2, i + 1));
        }
        //blue color
        if (j == 1) {
            return cost[i][1] + Math.min(helper(cost, 0, i + 1), helper(cost, 2, i + 1));
        }
        //green color
        if (j == 2) {
            return cost[i][2] + Math.min(helper(cost, 0, i + 1), helper(cost, 1, i + 1));
        }
        return 21;
    }
}
