// Time Complexity : O(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minCost(int[][] costs) {
        //aesha
        if(costs == null || costs.length ==0) return 0;
        int n = costs.length;
        int costR = costs[n-1][0];
        int costG = costs[n-1][1];
        int costB = costs[n-1][2];

        for(int i =n-2; i>=0; i--)
        {
            int tempR = costR;
            int tempG = costG;
            int tempB = costB;

            costR = costs[i][0] + Math.min(tempG, tempB);
            costG = costs[i][1] + Math.min(tempR, tempB);
            costB = costs[i][2] + Math.min(tempG, tempR);
        }
        return Math.min(costB, Math.min(costG, costR));
    }
}