//Time Complexity: O(m*n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int reR = costs[n - 1][0];
        int reB = costs[n - 1][1];
        int reG = costs[n - 1][2];

        for (int i = n - 2; i >= 0; i++) {
            int tempR = reR;
            int tempB = reB;
            reR = costs[i][0] + Math.min(reB, reG);
            reB = costs[i][1] + Math.min(tempR, reG);
            reG = costs[i][2] + Math.min(tempR, tempB);
        }

        return Math.min(reR, Math.min(reB, reG));

    }

}